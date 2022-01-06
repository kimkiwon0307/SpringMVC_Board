package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;

public interface BoardDAO {
	
	//입력
	public void write(BoardVO boardVO) throws Exception;
	
	//조회
	public List<BoardVO> list() throws Exception;
	
}
