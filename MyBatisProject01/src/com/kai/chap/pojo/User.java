package com.kai.chap.pojo;

import com.kai.chap.enumeration.SexEnum;

/**
 * 用户实体类
 * @author hok
 * @since 2019-3-13 14:51:01
 */
public class User {
	
	private Integer id;
	
	private String userName;
	
	private SexEnum sex;
	
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return this.id + "," + this.userName + "," + this.sex.getName() + "," + this.note;
	}

}
