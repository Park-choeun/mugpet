package com.spring.mugpet.controller.member;

public class NewAccountCommand {
	
	private String nickname;
	private String name;
	private String u_id;
	private String email;
	private String pwd;
	private String checkPwd;
	private String phoneNum;
	private String address;
	
	
	
	
	public NewAccountCommand(String nickname, String name, String u_id, String email, String pwd, String checkPwd,
			String phoneNum, String address) {
		super();
		this.nickname = nickname;
		this.name = name;
		this.u_id = u_id;
		this.email = email;
		this.pwd = pwd;
		this.checkPwd = checkPwd;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCheckPwd() {
		return checkPwd;
	}
	public void setCheckPwd(String checkPwd) {
		this.checkPwd = checkPwd;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	

}
