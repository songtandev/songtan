package com.web.songtan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.songtan.domain.BoardVO;
import com.web.songtan.service.BoardService;

@Controller
public class MainController {

		@Autowired
		private BoardService boardService;
		
		// 사용자 리스트 조회 controller 
		@RequestMapping("/")
		public String selectUserList(Model model) throws Exception
		{
			System.out.println("Controller");
			List<BoardVO> userInfo = boardService.selectList();
			BoardVO chanik = userInfo.get(0);
			model.addAttribute("info", userInfo);
			return "home";
		}
		
		// excel 파일 export controller 
		@RequestMapping("/export")
		public @ResponseBody boolean exportFile(@ModelAttribute("boardVO") BoardVO boardVO) throws Exception
		{
			System.out.println("export");
			boolean flag = boardService.exportFile(boardVO);
			return flag;
		}
}
