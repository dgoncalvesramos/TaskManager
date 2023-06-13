package com.myapp.taskmanager.model;
import javafx.beans.property.*;
import java.time.LocalDate;
public class Task {
    private StringProperty name = new SimpleStringProperty();
    private ObjectProperty<LocalDate> dueDate = new SimpleObjectProperty<>();
    private StringProperty priority = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();

    public Task(String taskName, LocalDate dueDate, String priority) {
        this.name.set(taskName);
        this.dueDate.set(dueDate);
        this.priority.set(priority);
        this.status.set("En cours");
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public LocalDate getDueDate() {
        return dueDate.get();
    }

    public ObjectProperty<LocalDate> dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate.set(dueDate);
    }

    public String getPriority() {
        return priority.get();
    }

    public StringProperty priorityProperty() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
