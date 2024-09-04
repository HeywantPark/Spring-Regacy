package org.example.service.board;

import org.springframework.stereotype.Service;
import org.example.dto.board.BoardDto;
import java.util.List;

@Service
public interface BoardService {
    List<BoardDto> getList();
    BoardDto detail(Long id);
    void create(BoardDto board);
    BoardDto update(BoardDto board);
    BoardDto delete(Long id);
}
