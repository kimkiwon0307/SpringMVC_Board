package kr.co.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
}
