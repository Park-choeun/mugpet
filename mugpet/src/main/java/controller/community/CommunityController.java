package controller.community;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("~~~~")
public class CommunityController {
	/*진행 상황에 따라 코드 수정 必*/
	
	@RequestMapping("필요하다면 사용")
	public String viewCommunity() {
		//게시글 상세보기
		
		return "~~~~";
	}
	
	@RequestMapping("필요하다면 사용")
	public String commuityList() {
		//게시글 목록 보기
		
		return "~~~~";
	}
	
	@RequestMapping("필요하다면 사용")
	public String deleteCommunity(int com_id) {
		//게시글 삭제
		
		return "~~~~";
	}
	
	//글 수정 버튼 클릭 시, 수정 폼으로 이동
	@RequestMapping(method = RequestMethod.GET)
	public String updateForm(int com_id) {
		
		return "~~~~";
	}
	
	//수정 폼에서 수정 완료 버튼 클릭 시, 해당 글과 관련된 내용을 db에 수정해 저장 후 목록or상세보기 페이지로 이동
	@RequestMapping(method = RequestMethod.POST)
	public String updateSubmit() {
		
		return "~~~~";
	}
	
	//글 작성 버튼 누르면 폼으로 이동
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		
		return "~~~~";
	}
	
	//폼에서 작성 완료 버튼을 누르면 해당 글과 관련된 내용을 db에 저장 후 목록or상세보기 페이지로 이동
	@RequestMapping(method = RequestMethod.POST)
	public String submit(NewCommunityCommand comCommand) {
		
		return "~~~~";
	}
}