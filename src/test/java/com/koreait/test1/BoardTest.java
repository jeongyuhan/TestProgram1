package com.koreait.test1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.test1.config.BeanConfiguration;
import com.koreait.test1.dao.BoardDAO;
import com.koreait.test1.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {BeanConfiguration.class})
public class BoardTest {

	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void insertTest() {
		BoardDTO board = new BoardDTO();
		board.setBWriter("테스터");
		board.setBTitle("테스트제목");
		board.setBContent("테스트내용");
		
		String bWriter = board.getBWriter();
		String bTitle = board.getBTitle();
		String bContent = board.getBContent();
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		
		int count = boardDAO.insertBoard(bWriter, bTitle, bContent);
		
		assertEquals("작성 실패", 1, count);
	}
	
	@Test
	public void selectTest() {
		int bIdx = 9999;
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		
		BoardDTO boardDTO = boardDAO.selectBybIdx(bIdx);
		
		int result = 0;
		if(boardDTO == null) {
			result = 0;
		} else {
			result = 1;
		}
		
		assertEquals("검색 실패", 1, result);
	}
	
	@Test
	public void updateTest() {
		BoardDTO board = new BoardDTO();
		board.setBTitle("변경공지사항제목");
		board.setBContent("변경공지사항내용");
		board.setBIdx(9999);
		
		String bTitle = board.getBTitle();
		String bContent = board.getBContent();
		int bIdx = board.getBIdx();
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.updateBoard(bTitle, bContent, bIdx);
		
		assertEquals("수정 실패", 1, result);
	}
	
	@Test
	public void deleteTest() {
		BoardDTO board = new BoardDTO();
		board.setBIdx(9999);	
		int bIdx = board.getBIdx();
		
		BoardDAO boardDAO = sqlSession.getMapper(BoardDAO.class);
		int result = boardDAO.deleteBoard(bIdx);
		
		assertEquals("수정 실패", 1, result);
	}
	
}
