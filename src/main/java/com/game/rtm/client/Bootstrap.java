package com.game.rtm.client;

import com.game.rtm.client.config.GameRtmClientConfigService;
import com.game.rtm.client.net.NetConnection;

import java.util.Map;

/**
 * @author twjitm
 */
public class Bootstrap {


    public static void startUp(Map<String, Object> args) {
        GameRtmClientConfigService.getInstance().init(args);
        new Thread(() -> new NetConnection((int) GameRtmClientConfigService.getInstance().getRtmClientConfig().getServerPort(),
                GameRtmClientConfigService.getInstance().getRtmClientConfig().getServerHost()).run()).start();
    }
}
