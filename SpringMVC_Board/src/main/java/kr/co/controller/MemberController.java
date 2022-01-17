package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.MemberService;
import kr.co.vo.MemberVO;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	//get 회원가입
	@GetMapping("/register")
	public void getRegister() throws Exception{
	}
	
	//post 회원가입
	@PostMapping("/register")
	public String postRegister(MemberVO vo) throws Exception{
		
		service.register(vo);
		
		try { 
			if(service.idChk(vo) == 1) {
				return "/member/register";
			}else if(service.idChk(vo) == 0) {
				service.register(vo);
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		if(login == null) {
			
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg",false);
		}else {
			session.setAttribute("member", login);
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/memberUpdateView")
	public String registerUpdateView() throws Exception{
		
		return "member/memberUpdateView";
	}
	
	
	@PostMapping("/memberUpdate")
	public String registerUpdate(MemberVO vo, HttpSession session) throws Exception {
		
		service.memberUpdate(vo);
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@GetMapping("/memberDeleteView")
	public String memberDeleteView() throws Exception{
		return "member/memberDeleteView";
	}
	
	@PostMapping("/memberDelete")
	public String memberDelete(MemberVO vo, HttpSession session, RedirectAttributes rttr)throws Exception{
		
		MemberVO member = (MemberVO)session.getAttribute("member");
		
		String sessionPass = member.getUserPass();
		
		String voPass = vo.getUserPass();
		
		if(!(sessionPass.equals(voPass))) {
			
			rttr.addFlashAttribute("msg", false);
			return "redirect:/member/memberDeleteView";
		}
		
		service.memberDelte(vo);
		session.invalidate();
		return "redirect:/";
	}
	
	//패스워드 체크
	@ResponseBody
	@PostMapping("/passChk")
	public int passChk(MemberVO vo) throws Exception{
		
		return service.passChk(vo);
		
	}
	
	//아이디 중복 체크
	@ResponseBody
	@PostMapping("/idChk")
	public int idChk(MemberVO vo) throws Exception {
		return service.idChk(vo);
	}
	
	
	
	
}
