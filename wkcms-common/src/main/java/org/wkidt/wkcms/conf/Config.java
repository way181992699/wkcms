package org.wkidt.wkcms.conf;

/**
 * Created by USER on 2017/6/22.
 */
public final class Config {
    public static final String USER_KEY = "user";
    public static final String CODE_VERIFY = "verify";

    public static final String USER_AGENT_ANDROID = "app_android";
    public static final String USER_AGENT_IOS = "app_ios";

    /**
     * 客户段识别
     *
     * @param userAgent
     * @return
     */
    public static boolean isMobileDevices(String userAgent) {
        return userAgent.toLowerCase().contains(USER_AGENT_ANDROID)
                || userAgent.toLowerCase().contains(USER_AGENT_IOS);
    }

}
