package com.game.rtm.client.net;


import com.game.rtm.client.config.GameRtmClientConfigService;
import io.netty.util.AttributeKey;

/**
 * @author twjitm 2019/4/15/22:52
 */
public class GameRtmClientManager {
    private NetClient client;
    private static final GameRtmClientManager SINGLETON = new GameRtmClientManager();

    public static GameRtmClientManager getSingleton() {
        return SINGLETON;
    }

    public void setClient(NetClient client) {
        this.client = client;
    }

    public void bandSession(long sessionId) {
        if (getClient() == null) {
            return;
        }

        String topic = GameRtmClientConfigService.getInstance().getRtmClientConfig().getTopic();
        getClient().getChannel().attr(AttributeKey.valueOf(topic)).set(sessionId);
    }

    public NetClient getClient() {
        return client;
    }

    public long getSession() {
        if (getClient() == null) {
            return 0L;
        }
        String topic = GameRtmClientConfigService.getInstance().getRtmClientConfig().getTopic();
        Object session = getClient().getChannel().attr(AttributeKey.valueOf(topic)).get();
        if (session == null) {

            return 0L;
        }
        return Long.parseLong(session.toString());
    }
}
