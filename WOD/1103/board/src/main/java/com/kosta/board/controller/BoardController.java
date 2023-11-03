package com.kosta.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kosta.board.dto.Board;
import com.kosta.board.dto.Member;
import com.kosta.board.dto.PageInfo;
import com.kosta.board.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private HttpSession session;
	
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
		System.out.println("modify Controller num : " + num);
		try {
			boardService.fileView(num, res.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="boarddetail", method=RequestMethod.GET)
	public ModelAndView boardDetail(@RequestParam("num") Integer num) {
		ModelAndView mav = new ModelAndView();
		
		try {
			Board board = boardService.boardDetail(num);
			mav.addObject("board",board);
			Member user = (Member)session.getAttribute("user");
			if(user != null) {
				Boolean select = boardService.isBoardLike(user.getId(), num);
				mav.addObject("select", select);
			}
			mav.setViewName("detailform");
		} catch( Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 상세 조회 오류");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	
	@RequestMapping(value="/boardmodify", method=RequestMethod.GET)
	public ModelAndView boardmodify(@RequestParam("num") Integer num) {
		ModelAndView mav = new ModelAndView();
		try {
			Board board = boardService.boardDetail(num);
			mav.addObject("board",board);
			mav.setViewName("modifyform");
		} catch( Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 상세 조회 오류");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/boardmodify", method=RequestMethod.POST)
	public ModelAndView boardmodify(@ModelAttribute Board board, @RequestParam("file") MultipartFile file) {
		ModelAndView mav = new ModelAndView();
		System.out.println("BoardNum Controller : " + board.getNum());
		
		try {
			Board modifyboard = boardService.modifyBoard(board, file);
			mav.addObject("board",modifyboard);
			mav.setViewName("redirect:/boarddetail?num="+board.getNum());
		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err","글 수정 오류");
			mav.setViewName("error");
			
		}
		return mav;
	}
	
	@RequestMapping(value="/boarddelete/{num}/{page}", method=RequestMethod.GET)
	public String boarddelete(@PathVariable Integer num, @PathVariable Integer page) {
		
		
		try {
			boardService.removeBoard(num);
			return "redirect:/boardlist?page="+page;
		} catch(Exception e) {
			e.printStackTrace();
			return "error";
		
		}	
	}
	
	@RequestMapping(value="/like", method=RequestMethod.POST)
	@ResponseBody
	public String boardLike(@RequestParam("num") Integer num) {
		Member user = (Member)session.getAttribute("user");
		try {
			if(user==null) throw new Exception("로그인 필요");
//			Boolean select = boardService.selectBoardLike(user.getId(), num);
			return String.valueOf(boardService.selectBoardLike(user.getId(), num));
		} catch(Exception e) {
			e.printStackTrace();
			return "false";
		}
	}	
}
