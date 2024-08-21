package org.example.repository.todo;

import lombok.RequiredArgsConstructor;
import org.example.domain.Todo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Repository
public class TodoRepository {

    private final EntityManager em;

    public List<Todo> findAll() {
        String jpql = "SELECT t FROM Todo t";
        return em.createQuery(jpql, Todo.class).getResultList();
    }
    public Todo findById(Long id) {
        return em.find(Todo.class, id);
    }
    public Todo save(Todo newTodo) {
        em.persist(newTodo);
        return newTodo;
    }
    public boolean updateDone(Long id) {
        Todo todo = em.find(Todo.class, id);

        if (todo != null) {
            todo.setDone(!todo.isDone());
            em.merge(todo);
            return true;
        }
        return false;
    }
    public Todo update(Todo updatedTodo) {
        em.merge(updatedTodo);
        return updatedTodo;
    }
    public void delete(Long id) {
        Todo todo = em.find(Todo.class, id);
        if(todo != null)em.remove(todo);
    }
}
