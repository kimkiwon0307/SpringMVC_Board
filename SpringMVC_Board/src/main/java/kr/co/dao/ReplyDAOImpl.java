package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	private SqlSession sql;

	
	// 댓글 조회
	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		return sql.selectList("replyMapper.readReply", bno);
	}


	@Override
	public void writeReply(ReplyVO vo) throws Exception {
	
		sql.insert("replyMapper.writeReply",vo);
		
	}
		


}
