package kr.co.service;

import kr.co.vo.MemberVO;

public interface MemberService {

	//회원가입
	public void register(MemberVO vo) throws Exception; 
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;
	
	//회원정보 수정
	public void memberUpdate(MemberVO vo) throws Exception;
	
	//회원탈퇴
	public void memberDelte(MemberVO vo) throws Exception;
	
	//패스워드 확인
	public int passChk(MemberVO vo) throws Exception;
	
	//아이디 중복 체크
	public int idChk(MemberVO vo) throws Exception;
}
