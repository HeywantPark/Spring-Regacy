package org.example.service.board;

import lombok.RequiredArgsConstructor;
import org.example.dto.board.BoardDto;
import org.example.mapper.Board2Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final Board2Mapper board2Mapper;

    @Override
    public List<BoardDto> getList() {
        return board2Mapper.getList();
    }

    @Override
    public BoardDto detail(Long id) {
        return board2Mapper.detail(id);
    }

    @Override
    public void create(BoardDto board) {
        board2Mapper.create(board);
    }

    @Override
    public BoardDto update(BoardDto board) {
        board2Mapper.update(board);
        BoardDto updateBoard = board2Mapper.detail(board.getNo());
        return updateBoard;

    }

    @Override
    public BoardDto delete(Long id) {
        board2Mapper.delete(id);
        return detail(id);
    }
}
