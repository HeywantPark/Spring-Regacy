package org.example.controller.todo;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoShowControllerV2 {
    private TodoDtoListV1 todoDtoList = TodoDtoListV1.getInstance();

    @GetMapping("/todo/v2/show")
    public String process(HttpServletRequest request, Model model) {
        log.info("====> TODO 리스트 보기 페이지 호출, /todo/show");

        model.addAttribute("todoList", todoDtoList.getList());
        return "todo-show2";
    }

}
