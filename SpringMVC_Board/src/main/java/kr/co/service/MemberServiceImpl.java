package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	// 회원가입
	@Override
	public void register(MemberVO vo) throws Exception {
		dao.register(vo);
	}

	// 로그인
	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return dao.login(vo);
	}

	// 회원정보 수정
	@Override
	public void memberUpdate(MemberVO vo) throws Exception {
		
		dao.memberUpdate(vo);
	}

	//회원탈퇴
	@Override
	public void memberDelte(MemberVO vo) throws Exception {
		dao.memberDelete(vo);
	}

	@Override
	public int passChk(MemberVO vo) throws Exception {
		return dao.passChk(vo);
	}

	@Override
	public int idChk(MemberVO vo) throws Exception {
		return dao.idChk(vo);
	}

	
	
	
}
