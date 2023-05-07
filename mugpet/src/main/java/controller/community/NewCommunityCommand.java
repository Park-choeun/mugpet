package controller.community;

import java.util.Date;

public class NewCommunityCommand {
	private int com_id;
	private String imageURL;
	private String title;
	private String content;
	private Date enrollDt;
	private int likes;
	private NewReplyCommand reply;
	private int comCnt;
	private int u_id;
	
	public NewCommunityCommand() {
		super();
	}

	public NewCommunityCommand(int com_id, String imageURL, String title, String content, Date enrollDt, int likes,
			NewReplyCommand reply, int comCnt, int u_id) {
		super();
		this.com_id = com_id;
		this.imageURL = imageURL;
		this.title = title;
		this.content = content;
		this.enrollDt = enrollDt;
		this.likes = likes;
		this.reply = reply;
		this.comCnt = comCnt;
		this.u_id = u_id;
	}

	public int getCom_id() {
		return com_id;
	}

	public void setCom_id(int com_id) {
		this.com_id = com_id;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public NewReplyCommand getReply() {
		return reply;
	}

	public void setReply(NewReplyCommand reply) {
		this.reply = reply;
	}

	public int getComCnt() {
		return comCnt;
	}

	public void setComCnt(int comCnt) {
		this.comCnt = comCnt;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
}