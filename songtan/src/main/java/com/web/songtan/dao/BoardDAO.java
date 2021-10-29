package com.web.songtan.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.songtan.domain.BoardVO;

@Repository
public class BoardDAO {

		@Autowired
		private SqlSession sqlSession;
		
		public List<BoardVO> selectList()
		{
			System.out.println("DAO");
			return sqlSession.selectList("board.selectList");
		}
}
