package com.spring.mugpet.domain;

/*AdminMember Domain 클래스*/
public class AdminMember {
	private String adminEmail;
	private String adminPwd;
	
	public AdminMember() {
	
	}

	public AdminMember(String adminEmail, String adminPwd) {
		super();
		this.adminEmail = adminEmail;
		this.adminPwd = adminPwd;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
}