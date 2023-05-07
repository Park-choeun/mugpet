package domain;

import java.util.Date;

public class Community {
	private int com_id;
	private String imageUrl;
	private String title;
	private String content;
	private Date enrollDt;
	private int likes;
	private Reply reply;
	private int comCnt;
	private int u_id;
	
	public Community() {
		
	}
		
	public Community(int com_id, String imageUrl, String title, String content, Date enrollDt, int likes, Reply reply,
			int comCnt, int u_id) {
		super();
		this.com_id = com_id;
		this.imageUrl = imageUrl;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
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
