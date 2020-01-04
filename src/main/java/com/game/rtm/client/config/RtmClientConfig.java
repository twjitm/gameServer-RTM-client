package com.game.rtm.client.config;

/**
 * @author twjitm
 */
public class RtmClientConfig {

    private String topic;
    private String serverHost;
    private long serverPort;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public long getServerPort() {
        return serverPort;
    }

    public void setServerPort(long serverPort) {
        this.serverPort = serverPort;
    }
}
