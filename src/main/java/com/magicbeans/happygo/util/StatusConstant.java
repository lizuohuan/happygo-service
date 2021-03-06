package com.magicbeans.happygo.util;

public class StatusConstant {


	// 用户状态
	/** 无效/冻结 */
	public static final Integer INVALID = 0;
	/** 有效 */
	public static final Integer VALID = 1;


	public static final Integer NO = 0;
	public static final Integer YES = 1;

	// 错误代码
	/**获取成功*/
	public static final Integer SUCCESS_CODE = 200;
	// 201 备用
	/**获取失败*/
	public static final Integer Fail_CODE = 202;
	/**参数异常*/
	public static final Integer ARGUMENTS_EXCEPTION = 203;

	
	
	/**没有权限 错误代码*/
	public static final Integer NOT_AGREE = 1001;
	/**对象不存在*/
	public static final Integer OBJECT_NOT_EXIST = 1002;
	/**字段不能为空*/
	public static final Integer FIELD_NOT_NULL= 1003;
	/**正在审核*/
	public static final Integer PENDING = 1004;
	/**未登录*/
	public static final Integer NOTLOGIN= 1005;
	/**没有数据*/
	public static final Integer NO_DATA = 1006;
	/**账户被冻结*/
	public static final Integer ACCOUNT_FROZEN = 1007;
	/**订单无效*/
	public static final Integer ORDER_INVALID = 1008;
	/**状态异常*/
	public static final Integer ORDER_STATUS_ABNORMITY = 1009;
	/**对象已经存在*/
	public static final Integer OBJECT_EXIST = 1010;

	/** 用户不存在 */
	public static final Integer USER_DOES_NOT_EXIST = 1050;
	/** 用户名或者密码错误 */
	public static final Integer PASSWORD_ERROR = 1051;

	/** 电话号码已存在 */
	public static final Integer PHONE_NUMBER_THERE = 1052;
	/** 账号已存在 */
	public static final Integer USER_NAME_ALREADY_EXISTS = 1053;
	/** 邮箱已存在 */
	public static final Integer EMAIL_IS_EXISTENCE = 1054;




	// 设备类型
	/**android*/
	public static final Integer ANDROID=0;
	/**ios*/
	public static final Integer IOS = 1;

	/** 支付状态   未支付 */
	public static final Integer NO_PAY = 0;
	/** 支付状态   已支付 */
	public static final Integer YES_PAY = 1;


	/** 未通过 */
	public static final Integer ACCOUNT_NON_APPROVED = 0;

	/** 审核通过 */
	public static final Integer ACCOUNT_APPROVED = 1;

	/** 审核中 */
	public static final Integer ACCOUNT_APPROVED_ING = 2;

	/** 登录有效时间  30天 */
	public static final Integer LOGIN_VALID = 30;


	// 订单状态

	/** 订单待支付 */
	public static final Integer ORDER_WAITING_PAY = 0;

	/** 订单已支付 */
	public static final Integer ORDER_PAID = 1;

	/** 订单待发货 */
	public static final Integer ORDER_WAITING_SEND = 2;

	/** 订单已发货 */
	public static final Integer ORDER_SENT = 3;

	/** 订单已完成 */
	public static final Integer ORDER_FINISHED = 4;

	/** 取消订单 */
	public static final Integer ORDER_CANCEL = 5;

	/** 申请退款中 */
	public static final Integer ORDER_REFUND = 6;

	/** 拒绝退款 */
	public static final Integer ORDER_REFUSE_REFUND = 7;

	/** 已退款 */
	public static final Integer ORDER_AGREE_REFUND = 8;



	// 订单支付方式

	/** 订单支付 - 支付宝 */
	public static final Integer PAY_METHOD_ALIPAY = 0;

	/** 订单支付 - 微信 */
	public static final Integer PAY_METHOD_WECHAT = 1;

	/** 订单支付 - 欢喜券 */
	public static final Integer PAY_METHOD_HXQ = 2;

	/** 订单支付 - 线下 */
	public static final Integer PAY_METHOD_UNDER_LINE = 3;






	
}
