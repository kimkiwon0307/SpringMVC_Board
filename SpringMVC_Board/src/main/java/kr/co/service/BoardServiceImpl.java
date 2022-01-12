package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.BoardDAO;
import kr.co.vo.BoardVO;
import kr.co.vo.Criteria;
import kr.co.vo.SearchCriteria;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO dao;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}

//	@Override
//	public List<BoardVO> list() throws Exception {
//		return dao.list();
//	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return dao.read(bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		dao.update(boardVO);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
/**
	@Override
	public List<BoardVO> list(Criteria cri) throws Exception {
		return dao.list(cri);
	}

	@Override
	public int listCount() throws Exception {
		return dao.listCount();
	}
**/

	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return dao.list(scri);
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return dao.listCount(scri);
	}
	
	
	
	

}
