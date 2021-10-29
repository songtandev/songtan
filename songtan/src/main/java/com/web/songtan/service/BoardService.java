package com.web.songtan.service;

import java.util.List;

import com.web.songtan.domain.BoardVO;

public interface BoardService {
	
	// 사용자 List 조회
	public List<BoardVO> selectList();
	// 사용자 List excel 파일 export 
	public boolean exportFile(BoardVO boardVO) throws Exception;
}
