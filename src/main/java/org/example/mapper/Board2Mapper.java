package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.board.BoardDto;

import java.util.List;

@Mapper
public interface Board2Mapper {
    public List<BoardDto> getList();
    public BoardDto detail(Long no);
    public int create(BoardDto board);
    public int update(BoardDto board);
    public int delete(Long no);
}
