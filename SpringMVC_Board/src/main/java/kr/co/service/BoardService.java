package kr.co.service;

import java.util.List;

import kr.co.vo.BoardVO;

public interface BoardService {
	
	
	//작성
	public void write (BoardVO boardVO) throws Exception;
	
	//리스트
	public List<BoardVO> list() throws Exception;
	
	//조회
	public BoardVO read(int bno) throws Exception;
	
	//수정
	public void update(BoardVO boardVO) throws Exception;
	
	//삭제
	public void delete(int bno) throws Exception;
 }
