package vttp.batch5.ssf.todolist.models;

import java.util.LinkedList;
import java.util.List;

public class Tasks {
    private List<Task> tasks = new LinkedList<>();

    @Override
    public String toString() {
        return "Tasks [tasks=" + tasks + ", getContent()=" + getContent() + ", getSize()=" + getSize() + ", toString()="
                + super.toString() + "]";
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

    public int getSize() {
        return tasks.size();
    }
}
