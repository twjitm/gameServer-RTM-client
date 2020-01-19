package com.game.rtm.client.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;


public class NetClient {
    private Channel channel;
    private NetConnection netConnection;

    public NetClient(Channel channel, NetConnection netConnection) {
        this.channel = channel;
        this.netConnection = netConnection;
    }

    public void writeData(int cmd, int status, byte[] data) {
        if (!isConnection()) {
            return;
        }
        ByteBuf buff = MessageCoderFactory.getSingleton().encode(cmd, status, data);
        this.channel.writeAndFlush(buff);

    }

    public void writeData(int cmd, byte[] data) {
        writeData(cmd, 0, data);
    }

    private boolean isConnection() {
        return channel != null;
    }

    public Channel getChannel() {
        return channel;
    }

    public NetConnection getNetConnection() {
        return netConnection;
    }

}
