package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.service.BoardService;
import kr.co.vo.BoardVO;

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
	
	@GetMapping("list")
	public String list(Model model) throws Exception{
		
		model.addAttribute("list", service.list());
		
		
		return "board/list";
	}
	
	@GetMapping("readView")
	public String read(BoardVO boardVO, Model model)throws Exception {
		
		model.addAttribute("read", service.read(boardVO.getBno()));
		
		return "board/readView";
	}
	
	@GetMapping("updateView")
	public String updateView(BoardVO boardVO, Model model) throws Exception{
		
		model.addAttribute("update" , service.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	@PostMapping("update")
	public String update(BoardVO boardVO) throws Exception{
		
		service.update(boardVO);
		
		return "redirect:/board/list";
	}
	
	@PostMapping("delete")
	public String delete(BoardVO boardVO)throws Exception{
		
		service.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
	
}
