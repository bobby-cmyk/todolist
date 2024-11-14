package vttp.batch5.ssf.todolist.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Task {

    @NotNull(message="Must input a name")
    @NotEmpty(message="Name cannot be empty")
    private String name;

    @NotNull(message="Must input a priority level")
    @NotEmpty(message="Priority level cannot be empty")
    private String priority;

    @NotNull(message="Must input a date to complete by")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @FutureOrPresent(message="Must be current or a future date")
    private LocalDate date;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Task [name=" + name + ", priority=" + priority + ", date=" + date + "]";
    }
}
