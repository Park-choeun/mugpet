package controller.usedgoods;

public class NewUsedGoodsCommand {
	private String memberId;
	private String memebrPasswd;
	private String title;
	private String content;
	private Date date;
	private int price;
	private String imgUrl;
	
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemebrPasswd() {
		return memebrPasswd;
	}
	public void setMemebrPasswd(String memebrPasswd) {
		this.memebrPasswd = memebrPasswd;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
