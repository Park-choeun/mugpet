package com.spring.mugpet.controller.community;

public class NewReplyCommand {
	
	private String content;
	private int com_id;
	private int g_id;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
}
