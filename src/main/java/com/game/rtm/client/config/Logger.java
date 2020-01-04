package com.game.rtm.client.config;

/**
 * @author twjitm
 */
public class Logger {
    private boolean isDebug;

    public void debug(String message, Object... param) {
        if (isDebug) {
            System.out.println(String.format(message, param));
        }
    }


}
