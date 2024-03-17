package co.istad.todolistwithspringboot.repository;

import co.istad.todolistwithspringboot.model.Todo;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class TodoListDataSource {
    private List<Todo> todos = new ArrayList<>();
    public TodoListDataSource(){
        todos.add(new Todo(1, "Grocery Shopping", "Buy groceries for the week", false, LocalDate.now()));
        todos.add(new Todo(2, "Gym", "Workout for an hour", false, LocalDate.now()));
        todos.add(new Todo(3, "Read", "Read a chapter of a book", false, LocalDate.now()));
        todos.add(new Todo(4, "Call Mom", "Check up on Mom", false, LocalDate.now()));
        todos.add(new Todo(5, "Write Report", "Finish quarterly report for work", false, LocalDate.now()));
    }
    //Todo(id, task, description, isDone, createdAt)

}

