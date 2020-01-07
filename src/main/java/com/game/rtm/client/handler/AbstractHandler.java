package com.game.rtm.client.handler;


/**
 * @author twjitm
 */
public abstract class AbstractHandler implements IHandler {
    private long messageId;

    public AbstractHandler(long messageId) {
        this.messageId = messageId;
    }


    @Override
    public long messageId() {
        return messageId;
    }
}
