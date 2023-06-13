package com.myapp.taskmanager.model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class TaskManager {
    private ObservableList<Task> tasks;

    public TaskManager() {
        this.tasks = FXCollections.observableArrayList();
    }

    public ObservableList<Task> getTasks() {
        return this.tasks;
    }
    public void addTask(Task task) {
        tasks.add(task);
    }
}
