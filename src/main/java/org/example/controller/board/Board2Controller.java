package org.example.controller.board;

import lombok.RequiredArgsConstructor;
import org.example.dto.board.BoardDto;
import org.example.mapper.BoardMapper;
import org.example.service.board.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class Board2Controller {
    private final BoardService boardService;
    private final String context = "/board";

    // 문제 1. 게시판 목록 기능 구현하기
    @GetMapping("/list")
    public String listPage(Model model) {
        List<BoardDto> list = boardService.getList();
        model.addAttribute("list",list);
        return context + "/list";
    }

    // 게시글 작성 모드 페이지로 이동하는 메서드 -> 이미 완성 된 상태
    @GetMapping("/create")
    public String createPage() {
        return context + "/create";
    }

    // 문제 2. 게시글 작성 기능 구현하기
    @PostMapping("/create")
    public String create(BoardDto board) {
        boardService.create(board);
        return "redirect:/board/list";
    }

    // 문제 3. 게시글 내용 보기 기능 구현하기
    @GetMapping("/detail")
    public String detailPage(@RequestParam("id") Long id, Model model) {
        BoardDto findBoard = boardService.detail(id);
        model.addAttribute("board",findBoard);
        return context + "/detail";
    }

    // 문제 4. 게시글 삭제 기능 구현하기
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        boardService.detail(id);
        return "redirect:/board/list";
    }

    // 문제 5-1. 게시글 수정 기능 구현하기
    @GetMapping("/update")
    public String updatePage(@RequestParam("id") Long id, Model model) {
        BoardDto updateBoard = boardService.detail(id);
        model.addAttribute("board",updateBoard);
        return context + "/update";
    }

    // 문제 5-2. 게시글 수정 기능 구현하기
    @PostMapping("/update")
    public String update(BoardDto board) {
        boardService.update(board);
        return "redirect:/board/list";
    }
}
