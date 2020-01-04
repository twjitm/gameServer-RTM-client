package com.game.rtm.client.net;

import com.game.rtm.client.handler.IHandler;
import com.game.rtm.client.net.message.IoMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author twjitm 2019/4/15/22:40
 */
@ChannelHandler.Sharable
public class TcpClientHandler extends ChannelInboundHandlerAdapter {

    private
    NetConnection runnable;

    public TcpClientHandler(NetConnection runnable) {
        this.runnable = runnable;
    }

    /**
     * 客户端首次建立网络连接
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        SessionManager.getSingleton().setClient(new NetClient(ctx.channel(), runnable));
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }

    /**
     * 读取到服务器消息
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf) msg;
        IoMessage ioMessage = MessageCoderFactory.getSingleton().decode(ctx, byteBuf);
        IHandler handler = MessageRegister.getHandlerMap(ioMessage.getCmd());
        boolean check = handler.verification(ioMessage);
        if (check) {
            handler.handler(ioMessage);
        }
    }

    /**
     * 服务器异常
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        if (channel.isActive()) {
            ctx.close();
        }
    }


    /**
     * 主动关闭
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        SessionManager.getSingleton().getClient().getNetConnection().channelUnregistered();
    }
}
