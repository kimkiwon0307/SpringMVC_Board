package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Autowired 
	private SqlSession sqlSesssion;
	
	
	
	@Override
	public void write(BoardVO boardVO) throws Exception {

      sqlSesssion.insert("boardMapper.insert" , boardVO);
	}



	@Override
	public List<BoardVO> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSesssion.selectList("boardMapper.list");
	}

}
