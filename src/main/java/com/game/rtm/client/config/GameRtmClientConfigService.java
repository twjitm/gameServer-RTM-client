package com.game.rtm.client.config;


/**
 * @author twjitm
 */
public class GameRtmClientConfigService {

    private static GameRtmClientConfigService service = new GameRtmClientConfigService();

    private RtmClientConfig rtmClientConfig;

    public static GameRtmClientConfigService getInstance() {
        return service;
    }

    public void initConfig(String path) {


    }

    public RtmClientConfig getRtmClientConfig() {
        return rtmClientConfig;
    }
}
