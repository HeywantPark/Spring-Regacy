package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.dto.post.PostDto;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> findAll();
}
