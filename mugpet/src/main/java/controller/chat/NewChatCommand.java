package controller.chat;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class NewChatCommand {
	@NotEmpty
	private int chat_id;
	
	@NotEmpty
	private int sender_id;
	
	@NotEmpty
	private int receiver_id;
	
	@NotEmpty
	private String message;
	
	@NotEmpty
	private Date chatDt;
	
	public NewChatCommand() {
		super();
	}
	
	public NewChatCommand(int chat_id, int sender_id, int receiver_id, String message, Date chatDt) {
		super();
		this.chat_id = chat_id;
		this.sender_id = sender_id;
		this.receiver_id = receiver_id;
		this.message = message;
		this.chatDt = chatDt;
	}

	public int getChat_id() {
		return chat_id;
	}

	public void setChat_id(int chat_id) {
		this.chat_id = chat_id;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getChatDt() {
		return chatDt;
	}

	public void setChatDt(Date chatDt) {
		this.chatDt = chatDt;
	}
}