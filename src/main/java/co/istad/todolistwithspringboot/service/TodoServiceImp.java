package co.istad.todolistwithspringboot.service;

import co.istad.todolistwithspringboot.model.Todo;
import co.istad.todolistwithspringboot.repository.TodoListDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImp implements TodoService {

    private final TodoListDataSource todoListDataSource;

    // Retrieve all todos
    @Override
    public List<Todo> getAllTodoList() {
        return todoListDataSource.getTodos();
    }

    // Add a new todo
    @Override
    public void addTodoList(Todo todo) {
        List<Todo> todoList = todoListDataSource.getTodos();

        // Generate new id for the todo
        Optional<Integer> maxId = todoList.stream().map(Todo::getId).max(Integer::compareTo);
        todo.setId(maxId.orElse(0) + 1);

        // Set creation date for the todo
        todo.setCreateAt(LocalDate.now());

        // Add the todo to the list
        todoList.add(todo);
    }

    // Delete a todo by id
    @Override
    public void deleteTodoList(Integer id) {
        List<Todo> todoList = todoListDataSource.getTodos();

        // Remove the todo with the specified id
        todoList.removeIf(todo -> todo.getId().equals(id));
    }

    // Update an existing todo
    @Override
    public void updateTodo(Todo todo) {
        todoListDataSource.getTodos().stream()
                .filter(t -> t.getId().equals(todo.getId()))
                .findFirst()
                .ifPresent(t -> {
                    // Update task, description, and status of the todo
                    t.setTask(todo.getTask());
                    t.setDescription(todo.getDescription());
                    t.setIsDone(todo.getIsDone());
                });
    }

    // Find a todo by its id
    @Override
    public Todo findById(Integer id) {
        return todoListDataSource.getTodos()
                .stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Search todos by task and status
    @Override
    public List<Todo> searchTodos(String task, Boolean isDone) {
        return todoListDataSource.getTodos().stream()
                .filter(todo -> (task == null || todo.getTask().toLowerCase().contains(task.toLowerCase())) &&
                        (isDone == null || todo.getIsDone().equals(isDone)))
                .collect(Collectors.toList());
    }
}
