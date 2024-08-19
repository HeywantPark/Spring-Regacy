package org.example.controller.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.post.PostDto;
import org.example.dto.post.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/post/v2/rest")
public class RestPostControllerV2 {
    private final PostRepository postRepository;
    private String context = "/post/v1/";

    //게시글 목록
    @GetMapping("/show")
    public ResponseEntity<List<PostDto>> postList(HttpServletRequest request) {
        log.info("=======> 게시글 목록 페이지 호출, " + request.getRequestURI());

        return ResponseEntity.ok(postRepository.findAll());
    }

    @GetMapping(value = "/test", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> test() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("요청을 처리할 수 없습니다.");
    }
    //게시글 검색
    @GetMapping("/search")
    public List<PostDto> postSearch(
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            HttpServletRequest request) {
        log.info("=======> 게시글 검색 기능 호출");
        return postRepository.findByCondition(title, content);
    }
    // 게시글 삭제
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> postDelete(@PathVariable("id") long id, HttpServletRequest request) {
        log.info("================> 게시글 삭제 기능 호출, " + request.getRequestURI());

        int affectedRows = postRepository.delete(id);

        if (affectedRows > 0) {
            return  ResponseEntity.ok("삭제 성공");
        } else {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제 실패");
        }
    }
}
