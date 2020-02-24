package com.yunheur.board.board.controller;

import java.util.List;

import com.yunheur.board.board.dto.BoardDto;
import com.yunheur.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestBoardApiController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/api/board")
	public List<BoardDto> openBoardList() throws Exception{
		return boardService.selectBoardList();
	}

	@PostMapping("/api/board")
	public void insertBoard(@RequestBody BoardDto board) throws Exception{
		boardService.insertBoard(board, null);
	}

	@GetMapping("/api/board/{boardIdx}")
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{

		return boardService.selectBoardDetail(boardIdx);
	}

	@PutMapping("/api/board/{boardIdx}")
	public String updateBoard(@RequestBody BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board";
	}

	@DeleteMapping("/api/board/{boardIdx}")
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}
}
