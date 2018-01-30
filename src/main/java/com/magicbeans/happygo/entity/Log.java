package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.magicbeans.happygo.AbstractLogService;
import com.magicbeans.base.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author magicbeans
 * @since 2017-12-26
 */
@TableName("t_log")
public class Log extends BaseEntity<Log> {

    private static final long serialVersionUID = 1L;

	private AbstractLogService.LogType type;

	@TableField("login_user")
	private String loginUser;
	private String ip;
	private String content;
	private String module;

	public AbstractLogService.LogType getType() {
		return type;
	}

	public void setType(AbstractLogService.LogType type) {
		this.type = type;
	}

	public String getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Log{" +
			"type=" + type +
			", loginUser=" + loginUser +
			", ip=" + ip +
			", content=" + content +
			", module=" + module +
			"}";
	}


}
