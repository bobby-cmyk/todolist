package vttp.batch5.ssf.todolist.models;

import java.util.LinkedList;
import java.util.List;

public class Tasks {
    private List<Task> tasks;

    public Tasks() {
        tasks = new LinkedList<>();
    }

    public List<Task> getContent() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }
}
