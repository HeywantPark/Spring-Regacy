package org.example.controller.todo.v2;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.todo.TodoDtoListV2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class TodoSaveControllerV2 {
    private TodoDtoListV2 todoDtoList;

    @RequestMapping(value = "/todo/v2/form/save", method = RequestMethod.GET)
    public String process(HttpServletRequest request , Model model) {
        log.info(" =========> 회원 추가 Request, /todo/form/save");

        String todo = request.getParameter("todo");
        todoDtoList.addList(todo);

        model.addAttribute("todoList", todoDtoList.getList());

        return "todo-show2";
    }
}
