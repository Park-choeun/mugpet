package domain;

public class ChatRoom {
	
	private int c_id;
	private int g_id;
	private String sellerId;
	private String buyerId;
	private String fileName; // 대화내용 저장 파일
	
	
	//not in DB
	
	private String content;
	private String sendTime;
	private String senderName;

	
	public ChatRoom() {}


	public ChatRoom(int c_id, int g_id, String sellerId, String buyerId, String fileName) {
		super();
		this.c_id = c_id;
		this.g_id = g_id;
		this.sellerId = sellerId;
		this.buyerId = buyerId;
		this.fileName = fileName;
	}
	
	
	public ChatRoom(String content, String sendTime, String senderName) {
		super();
		this.content = content;
		this.sendTime = sendTime;
		this.senderName = senderName;
	}




	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getG_id() {
		return g_id;
	}
	public void setG_id(int g_id) {
		this.g_id = g_id;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	

}
