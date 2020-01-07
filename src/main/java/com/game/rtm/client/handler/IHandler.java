package com.game.rtm.client.handler;

import com.game.rtm.client.net.message.IMessage;

/**
 * @author twjitm
 */
public interface IHandler {

    void handler(IMessage message);

    boolean verification(IMessage message);

    long messageId();

}
