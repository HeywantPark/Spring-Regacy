package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/post/v1/rest")
public class RestPostController {
    private final PostRepository postRepository;
    private String context = "/post/v1/";

    //게시글 목록
    @GetMapping("/show")
    public List<PostDto> postList(HttpServletRequest request, Model model) {
        log.info("=======> 게시글 목록 페이지 호출, " + request.getRequestURI());
        return postRepository.findAll();
    }
    //게시글 검색
    @GetMapping("/search")
    public List<PostDto> postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request,
            Model model) {
        log.info("=======> 게시글 검색 기능 호출");
        return postRepository.findByCondition(title, content);
    }
}
