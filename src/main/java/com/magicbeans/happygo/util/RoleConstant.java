package com.magicbeans.happygo.util;

/**
 * APP 用户角色等级常量
 * Created by Eric Xie on 2018/1/31 0031.
 */
public class RoleConstant {

    /** 普通会员
     *
     *  权益：暂无权益
     *
     *  */
    public static final Integer REGULAR_MEMBERS = 0;

    /**
     * 代理商普通会员
     * 权益：
     *       1、自身购买商品积分
     *       2、分销1级积分
     * */
    public static final Integer AGENT_REGULAR_MEMBERS = 1;

    /**
     *  代理商高级会员
     *  权益：
     *       1、自身购买商品积分
     *       2、分销2级积分
     * */
    public static final Integer AGENT_SENIOR_MEMBERS = 2;

    /**
     * 代理商VIP会员
     * 权益：
     *       1、自身购买商品积分
     *       2、分销3级积分
     *
     * */
    public static final Integer AGENT_VIP_MEMBERS = 3;

    /**
     * 代理商超级会员
     * 权益:
     *       1、自身购买商品积分
     *       2、一次性商品欢喜券
     *       3、分销3级积分
     *       4、分销1级提成欢喜券
     *
     * */
    public static final Integer AGENT_SUPPER_MEMBERS = 4;




}
