package com.game.rtm.client.config;


import com.game.rtm.client.net.MessageRegister;

import java.util.Map;

/**
 * @author twjitm
 */
public class GameRtmClientConfigService {

    private final static GameRtmClientConfigService service = new GameRtmClientConfigService();

    private RtmClientConfig rtmClientConfig;

    public static GameRtmClientConfigService getInstance() {
        return service;
    }

    public void init(Map<String, Object> params) {
        this.initConfig(params);
        this.initHandler();
    }


    private void initConfig(Map<String, Object> params) {
        rtmClientConfig = new RtmClientConfig();
        rtmClientConfig.setTopic(params.get("topic").toString());
        rtmClientConfig.setServerHost(params.get("host").toString());
        rtmClientConfig.setServerPort(Long.parseLong(params.get("port").toString()));
        rtmClientConfig.setNamespace(params.get("namespace").toString());

    }

    private void initHandler() {
        MessageRegister.autoRegister(rtmClientConfig.getNamespace());
    }

    public RtmClientConfig getRtmClientConfig() {
        return rtmClientConfig;
    }
}
