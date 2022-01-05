package kr.co.dao;

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

}
