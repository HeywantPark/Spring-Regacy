package org.example.controller.newTodo;

import com.sun.xml.bind.v2.TODO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Todo;
import org.example.repository.todo.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@Transactional
@RequestMapping("/todo")
@CrossOrigin(origins = "*")

public class newTodoController {
    private final TodoRepository todoRepository;

    @GetMapping("")
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable Long id) {
        Todo findTodo = todoRepository.findById(id);

        if (findTodo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(findTodo);
    }
    @PostMapping("/{todo}")
    public ResponseEntity<Todo> save(@PathVariable String todo) {
        Todo newTodo = new Todo(null,todo,false);
        Todo addedTodo = todoRepository.save(newTodo);

        if(addedTodo == null) return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(addedTodo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateDone(@PathVariable Long id) {
            boolean updated = todoRepository.updateDone(id);
            if (!updated) {
                return ResponseEntity.notFound().build();
            }
            Todo updatedTodo = todoRepository.findById(id);
            return ResponseEntity.ok(updatedTodo);

    }
    @PutMapping("/update/{id}/{todo}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @PathVariable String todo) {
        Todo findTodo = todoRepository.findById(id);
        if (findTodo == null) return ResponseEntity.notFound().build();
        findTodo.setTodo(todo);

        Todo updatedTodo = todoRepository.update(findTodo);
        return ResponseEntity.ok(updatedTodo);

    }
    @DeleteMapping(value = "/{id}", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Todo finTodo = todoRepository.findById(id);
        if (finTodo == null) return ResponseEntity.notFound().build();

        todoRepository.delete(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
