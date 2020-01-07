package com.game.rtm.handler;

import com.game.rtm.client.handler.AbstractHandler;
import com.game.rtm.client.net.message.IMessage;

/**
 * @author twjitm
 */
public class AuthHandler extends AbstractHandler {

    public AuthHandler() {
        super(1);
    }

    @Override
    public void handler(IMessage message) {
        System.out.println("收到来自远端服务器的消息" + message.messageId());
    }

    @Override
    public boolean verification(IMessage message) {
        return false;
    }
}
