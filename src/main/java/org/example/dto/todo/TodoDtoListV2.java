package org.example.dto.todo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TodoDtoListV2 {
    private List<TodoDto> todoDtoList;

    public TodoDtoListV2() {
        this.todoDtoList = new ArrayList<>();
        // 테스트 데이터 추가
        this.addList("spring 공부하기");
        this.addList("운동 하기");
    }

    public void addList(String todo) {
        todoDtoList.add(new TodoDto(todo));
    }

    public List<TodoDto> getList() {
        return todoDtoList;
    }
}
