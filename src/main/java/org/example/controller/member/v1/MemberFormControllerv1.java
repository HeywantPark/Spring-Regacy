package org.example.controller.member.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MemberFormControllerv1 {

    @GetMapping("/member/form")
    public String memberForm() {
        log.info("========> 회원 추가 페이지 호출, /member/form");
        return "member-form";
    }
}
