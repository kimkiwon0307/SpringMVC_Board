package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;
import kr.co.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired 
	private SqlSession sqlSesssion;
	
	
	
	@Override
	public void write(BoardVO boardVO) throws Exception {

      sqlSesssion.insert("boardMapper.insert" , boardVO);
	}



//	@Override
//	public List<BoardVO> list() throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSesssion.selectList("boardMapper.list");
//	}
//

//
//	@Override
//	public List<BoardVO> list(Criteria cri) throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSesssion.selectList("boardMapper.listPage", cri);
//	}


	
	
	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSesssion.selectOne("boardMapper.read",bno);
	}



	@Override
	public void update(BoardVO boardVO) throws Exception {
	
		sqlSesssion.update("boardMapper.update", boardVO);
		
	}



	@Override
	public void delete(int bno) throws Exception {

		sqlSesssion.delete("boardMapper.delete", bno);
	}



//	@Override
//	public int listCount() throws Exception {
//		// TODO Auto-generated method stub
//		return sqlSesssion.selectOne("boardMapper.listCount");
//	}



	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		return sqlSesssion.selectList("boardMapper.listPage", scri);
	}



	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return sqlSesssion.selectOne("boardMapper.listCount", scri);
	}

}
