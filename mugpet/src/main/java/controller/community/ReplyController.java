package controller.community;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {

	//댓글 작성 -> SpringMvcExample의 search controller처럼 변경해야할 듯함
	@RequestMapping("필요하다면 사용")
	public String form() {
		return "~~~~";
	}
	
	//댓글 등록 -> SpringMvcExample의 search controller처럼 변경해야할 듯함
	@RequestMapping("필요하다면 사용")
	public String submit(NewReplyCommand chatCommand) {
		return "~~~~";
	}
	
	/*u_id가 댓글 작성자 아이디!!
	 * 수정할 때 댓글 번호도 필요한가?? -> 댓글 여러개 작성했다면 필요할 듯함
	 * */
	@RequestMapping("수정 방식에 따라 변경")
	public String updateReplyForm(int rp_id, int u_id) {
		//댓글 수정
		
		return "~~~~";
	}
	
	@RequestMapping("필요하다면 사용")
	public String replyList(int com_id){
		//댓글 목록 보기
		
		return "~~~~";
	}
}