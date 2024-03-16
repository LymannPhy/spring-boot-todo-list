package co.istad.todolistwithspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createAt;
}
