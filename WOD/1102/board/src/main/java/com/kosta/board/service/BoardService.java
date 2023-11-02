package com.kosta.board.service;

import java.util.List;

import javax.servlet.ServletOutputStream;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.board.dto.Board;
import com.kosta.board.dto.PageInfo;

public interface BoardService {
	List<Board> boardListByPage(PageInfo pageInfo) throws Exception;

	Board writeBoard(Board board, MultipartFile file) throws Exception;

	void fileView(Integer num, ServletOutputStream outputStream) throws Exception;
}
