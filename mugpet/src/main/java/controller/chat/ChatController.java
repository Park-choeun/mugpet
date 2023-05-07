package controller.chat;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("~~~~")
public class ChatController {
	
	//채팅 작성 -> SpringMvcExample의 search controller처럼 변경해야할 듯함
	@RequestMapping("필요하다면 사용")
	public String form() {
		return "~~~~";
	}
	
	//채팅 전송 -> SpringMvcExample의 search controller처럼 변경해야할 듯함
	@RequestMapping("필요하다면 사용")
	public String submit(NewChatCommand chatCommand) {
		return "~~~~";
	}
	
	@RequestMapping("필요하다면 사용")
	public String chatList(int sender_id){
		//채팅 목록 보기
		
		return "~~~~";
	}
	
	@RequestMapping("필요하다면 사용")
	public String viewChat(int receiver_id) {
		//채팅 상세보기
		
		return "~~~~";
	}
}