package com.kosta.board.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		System.out.println("Controller num : " + num);
		try {
			FileVo fileVo = boardDao.selectFile(num);
//			FileCopyUtils.copy(fileVo.getData(), out);
			
			FileInputStream fis = new FileInputStream(fileVo.getDirectory()+num);
			FileCopyUtils.copy(fis, out);
			
			out.flush();
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Board boardDetail(Integer num) throws Exception {
		return boardDao.selectBoard(num);
	}

	@Override
	public Board modifyBoard(Board board, MultipartFile file) throws Exception {
		if(file!=null && !file.isEmpty()) {
			String dir = "/Users/baghaengbog/Desktop/Study/upload/";
			FileVo filevo = new FileVo();
			filevo = boardDao.selectFile(board.getNum());
			
			System.out.println("fileVo : " + filevo);
			
			System.out.println("게시물 번호 :" + board.getNum());
			if(filevo!=null) {
				System.out.println("업데이트할 파일 번호 : " + filevo.getNum());
			
			
				filevo.setDirectory(filevo.getDirectory());
				filevo.setName(file.getOriginalFilename());
				filevo.setSize(file.getSize());
				filevo.setContenttype(file.getContentType());
				filevo.setData(file.getBytes());
				
				System.out.println("file dir : " + filevo.getDirectory());
				
				boardDao.updateFile(filevo);
				Integer num = filevo.getNum();
				
				File uploadFile = new File(filevo.getDirectory()+num);
				// /Users/baghaengbog/Desktop/Study/upload/{num} 
				// 로 경로가 설정되어 자연스래 num 값이 파일명으로 됨
				
				System.out.println("uploadFile : " + uploadFile);
				
				file.transferTo(uploadFile); // file.transferTo(경로)
				board.setFileurl(""+num);
			} else {
				FileVo filevo2 = new FileVo();
				filevo2.setDirectory(dir);
				filevo2.setName(file.getOriginalFilename());
				filevo2.setSize(file.getSize());
				filevo2.setContenttype(file.getContentType());
				filevo2.setData(file.getBytes());
				
				boardDao.insertFile(filevo2);
				Integer num = filevo2.getNum();
				
				File uploadFile = new File(dir+num);
				// /Users/baghaengbog/Desktop/Study/upload/{num} 
				// 로 경로가 설정되어 자연스래 num 값이 파일명으로 됨
				System.out.println("uploadFile : " + uploadFile);
				file.transferTo(uploadFile); // file.transferTo(경로)
				board.setFileurl(""+num);
			}
			// 1. 파일정보 db에 추가
//			String dir = "/Users/baghaengbog/Desktop/Study/upload/";
//			FileVo filevo = new FileVo();
//			filevo.setDirectory(dir);
//			filevo.setName(file.getOriginalFilename());
//			filevo.setSize(file.getSize());
//			filevo.setContenttype(file.getContentType());
//			filevo.setData(file.getBytes());
//			boardDao.insertFile(filevo);
//			
//			// 2. upload 폴더에 파일 업로드
//			File uploadFile = new File(dir+filevo.getNum());
//			file.transferTo(uploadFile);
//			
//			// 3. 기존 파일번호 삭제 위해 받아놓기
//			Integer deleteFileNum = Integer.parseInt(board.getFileurl());
//			// 4. 파일번호를 board fileUrl에 복사 & board update
//			board.setFileurl(filevo.getNum()+"");
//			boardDao.updateBoard(board);
//			// 5. board fileUrldp 해당되는 파일 번호를파일 테이블에서 삭제
//			boardDao.deleteFile(deleteFileNum);
//		} else {
//			boardDao.updateBoard(board);
//		}
		
		// 5. board 테이블에 추가
		}
		
		boardDao.updateBoard(board);
		
		return boardDao.selectBoard(board.getNum());
	}

	@Override
	public void removeBoard(Integer num) throws Exception {
		Board board = boardDao.selectBoard(num);
		if(board!=null) {
			if(board.getFileurl()!="" && board.getFileurl()!= null) {
				boardDao.deleteFile(Integer.parseInt(board.getFileurl()));
				boardDao.deleteBoard(num);
			} else {
				boardDao.deleteBoard(num);
			}
			
		}
		
	}

	@Override
	public Boolean isBoardLike(String userId, Integer boardNum) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("id",userId);
		param.put("num", boardNum);
		Integer likeNum = boardDao.selectBoardLike(param);
		return likeNum==null ? false : true ;
	}

	@Override
	public Boolean selectBoardLike(String userId, Integer boardNum) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("id",userId);
		param.put("num", boardNum);
		Integer likeNum = boardDao.selectBoardLike(param);
		if(likeNum==null) {
			boardDao.insertBoardLike(param);
			boardDao.plusBoardLikeCount(boardNum);
			return true;
		} else {
			boardDao.deleteBoardLike(param);
			boardDao.minusBoardLikeCount(boardNum);
			return false;
		}
	}
}

