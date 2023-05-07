package controller.usedgoods;

public class UsedGoodsController {
	//private UsedGoodsDao usedGoodsDao; -> service에서 interface로 따로 구현해도 상관없음
	//private ArticleService articleService;
	
	/* UsedGoodsDao의 객체로 저장 
	 * public void setUsedGoodsDao(UsedGoodsDao usedGoodsDao) { this.usedGoodsDao = usedGoodsDao; }
	 */
	
	/*
	 * UsedGoodsDao 또는 비슷한 구성의 service 클래스의 객체로 중고거래 글 목록 불러오기, 수정 등의 메서드에
	 * 접근해 ModelAndView 메서드로 사용자 뷰에 전달
	 */
	
	//business method
	/*

	@RequestMapping(method = RequestMethod.GET)
	public String form() { 
		return "article/newArticleForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("command") NewArticleCommand command) {
		articleService.writeArticle(command);
		return "article/newArticleSubmitted";
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	*/
}
