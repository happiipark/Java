package com.kosta.board.service;

import java.io.File;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.board.dao.BoardDao;
import com.kosta.board.dto.Board;
import com.kosta.board.dto.FileVo;
import com.kosta.board.dto.PageInfo;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> boardListByPage(PageInfo pageInfo) throws Exception {
		int boardCount = boardDao.selectBoardCount();
		System.out.println("boardCount : " + boardCount);
		if(boardCount == 0) return null;
		
		int allPage = (int)Math.ceil((double)boardCount/10);
		int startPage = (pageInfo.getCurPage()-1)/10 * 10 + 1;
		int endPage = Math.min(startPage+10-1, allPage);
		
		pageInfo.setAllPage(allPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		if(pageInfo.getCurPage()>pageInfo.getAllPage()) pageInfo.setCurPage(allPage);
		
		int row = (pageInfo.getCurPage()-1) * 10 + 1;
		return boardDao.selectBoardList(row-1);
	}

	@Override
	public Board writeBoard(Board board, MultipartFile file) throws Exception {
		if(file!=null && !file.isEmpty()) {
			String dir = "/Users/baghaengbog/Desktop/Study/upload/";
			FileVo filevo = new FileVo();
			filevo.setDirectory(dir);
			filevo.setName(file.getOriginalFilename());
			filevo.setSize(file.getSize());
			filevo.setContenttype(file.getContentType());
			filevo.setData(file.getBytes());
			
			boardDao.insertFile(filevo);
			Integer num = filevo.getNum();
			
			File uploadFile = new File(dir+num);
			// /Users/baghaengbog/Desktop/Study/upload/{num} 
			// 로 경로가 설정되어 자연스래 num 값이 파일명으로 됨
			System.out.println("uploadFile : " + uploadFile);
			file.transferTo(uploadFile); // file.transferTo(경로)
			board.setFileurl(""+num);
			
		}
		
		boardDao.insertBoard(board);
		
		return boardDao.selectBoard(board.getNum());
	}

	@Override
	public void fileView(Integer num, ServletOutputStream out) throws Exception {
		try {
			FileVo fileVo = boardDao.selectFile(num);
			FileCopyUtils.copy(fileVo.getData(), out);
			out.flush();
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
	}
}
