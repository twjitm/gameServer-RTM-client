package com.game.rtm.handler;

import com.game.rtm.client.handler.AbstractHandler;
import com.game.rtm.client.net.GameRtmClientManager;
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
        String data = "你好，服务器";
        GameRtmClientManager.getSingleton().getClient().writeData(1, data.getBytes());
    }

    @Override
    public boolean verification(IMessage message) {
        return false;
    }
}
