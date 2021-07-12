package com.koreait.test1.command;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

public class SelectBoardListCommand implements BoardCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		model.addAttribute("list", boardDAO.selectBoardList());
		model.addAttribute("totalBoard", boardDAO.selectBoardCount());
		
		List<BoardDTO> list = boardDAO.selectBoardList();
		for(BoardDTO board : list) {
			System.out.println(board);
		}
		
	}

}
