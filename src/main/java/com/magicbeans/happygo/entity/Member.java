package com.magicbeans.happygo.entity;

import java.io.Serializable;

import com.magicbeans.base.BaseEntity;
import com.magicbeans.happygo.mybatis.inteface.EnumIdentifiable;

/**
 * <p>
 * 
 * </p>
 *
 * @author magicbeans
 * @since 2017-09-26
 */
public class Member extends BaseEntity<Member> {

	private static final long serialVersionUID = 1L;

	private Status status;

	private String name;

	private String password;



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Member{" +
				"status=" + status +
				", name=" + name +
				"}";
	}


	public enum Status implements EnumIdentifiable{

		ENABLE,DISABLE

	}
}
