package com.game.rtm.client.test;

import com.game.rtm.client.Bootstrap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author twjitm
 */
public class ClientTest {

    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>();
        param.put("host", "127.0.0.1");
        param.put("port", 8080);
        param.put("namespace", "com.game.rtm.handler");
        param.put("topic", "yuandian");
        Bootstrap.startUp(param);

    }
}
