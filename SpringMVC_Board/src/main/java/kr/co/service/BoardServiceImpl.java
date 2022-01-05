package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {

		dao.write(boardVO);
	}
	
	

}
