package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;
import kr.co.vo.PageMaker;
import kr.co.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	@GetMapping("writeView")
	public void writeView() throws Exception{
		
		
	}
	
	@PostMapping("write")
	public String write(BoardVO boardVO)throws Exception{
		
		service.write(boardVO);
		
		return "redirect:/";
	}
	
//	@GetMapping("list")
//	public String list(Model model) throws Exception{
//		
//		model.addAttribute("list", service.list());
//		
//		
//		return "board/list";
//	}
/**	
	@GetMapping("list")
	public String list(Model model , Criteria cri) throws Exception{
		
		model.addAttribute("list", service.list(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker",pageMaker);
		
		return "board/list";
	}
**/
	
	@GetMapping("/list")
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		
		model.addAttribute("list", service.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
		
	}
	
	
	@GetMapping("readView")
	public String read(BoardVO boardVO, Model model, @ModelAttribute("scri") SearchCriteria scri)throws Exception {
		
		
		model.addAttribute("scri", scri);
		model.addAttribute("read", service.read(boardVO.getBno()));
		
		return "board/readView";
	}
	
	@GetMapping("updateView")
	public String updateView(BoardVO boardVO, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		
		model.addAttribute("update" , service.read(boardVO.getBno()));
		model.addAttribute("scri", scri);
		
		return "board/updateView";
	}
	
	@PostMapping("update")
	public String update(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		
		service.update(boardVO);
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		
		return "redirect:/board/list";
	}
	
	@PostMapping("delete")
	public String delete(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr)throws Exception{
		
		service.delete(boardVO.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
}
