package controller.community;

import java.util.Date;

public class NewReplyCommand {
	private int rp_id;
	private String content;
	private Date enrollDt;
	private int u_id;
	private int com_id;
	
	public NewReplyCommand() {
		super();
	}

	public NewReplyCommand(int rp_id, String content, Date enrollDt, int u_id, int com_id) {
		super();
		this.rp_id = rp_id;
		this.content = content;
		this.enrollDt = enrollDt;
		this.u_id = u_id;
		this.com_id = com_id;
	}

	public int getRp_id() {
		return rp_id;
	}

	public void setRp_id(int rp_id) {
		this.rp_id = rp_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getEnrollDt() {
		return enrollDt;
	}

	public void setEnrollDt(Date enrollDt) {
		this.enrollDt = enrollDt;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}
}