package vttp.batch5.ssf.todolist.models;

import java.time.LocalDate;

public class Task {

    private String name;
    private String priority;
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
