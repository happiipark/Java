package com.kosta.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.board.dto.Board;
import com.kosta.board.dto.PageInfo;
import com.kosta.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	
	@RequestMapping(value = "/boardlist", method = RequestMethod.GET)
	public ModelAndView boardlist(@RequestParam(value="page" , required=false, defaultValue = "1") Integer page) {
		ModelAndView mav = new ModelAndView();
		try {
			PageInfo pageInfo = new PageInfo();
			pageInfo.setCurPage(page);
			List<Board> boardList = boardService.boardListByPage(pageInfo);
			mav.addObject("pageInfo",pageInfo);
			mav.addObject("boardList", boardList);
			mav.setViewName("boardlist");
		} catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value="/boardwrite", method=RequestMethod.GET)
	public String boardWrite() {
		return "writeform";
	}
	
	@RequestMapping(value="/boardwrite", method=RequestMethod.POST)
	public ModelAndView boardWrite(@ModelAttribute Board board, @RequestParam("file") MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		try {
			Board writeboard = boardService.writeBoard(board, file);
			mav.addObject("board",writeboard);
			mav.setViewName("detailform");
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 등록 오류");
			mav.setViewName("error");
			
		}
		return mav;
	}
	
	@RequestMapping(value="/image/{num}")
	public void imageView(@PathVariable Integer num, HttpServletResponse res) {
		try {
			boardService.fileView(num, res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
