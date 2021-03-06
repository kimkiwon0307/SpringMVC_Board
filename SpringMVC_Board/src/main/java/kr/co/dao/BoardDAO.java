package kr.co.dao;

import java.util.List;

import kr.co.vo.BoardVO;
import kr.co.vo.Criteria;
import kr.co.vo.SearchCriteria;

public interface BoardDAO {

	//입력
	public void write(BoardVO boardVO) throws Exception;
	
	//목록
/**
	목록의 변화 과정
		
	public List<BoardVO> list() throws Exception;
		//목록 조회
	public List<BoardVO> list(Criteria cri) throws Exception;
	
	
*/
	
	public List<BoardVO> list(SearchCriteria scri) throws Exception;
	

	//갯수
//	public int listCount() throws Exception;
	
	public int listCount(SearchCriteria scri) throws Exception;
	
	//조회
	public BoardVO read(int bno) throws Exception;
	
	//수정
	public void update(BoardVO boardVO) throws Exception;
		
	//삭제
	public void delete(int bno) throws Exception;
	
}
