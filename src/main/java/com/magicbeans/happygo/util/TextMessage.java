package com.magicbeans.happygo.util;

/**
 * Created by Eric Xie on 2018/1/30 0030.
 */
public class TextMessage {

    /** 注册短信 在缓存中的前缀 */
    public static final String REDIS_KEY_PREFIX = "register_code_";

    /** 验证码在缓存中存在的时间  分钟 */
    public static final Integer EXPIRE_TIME = 5;

    /**验证码类*/
    public static final String MSG_CODE = "您的验证码是{0}。如非本人操作，请忽略本短信";

}
