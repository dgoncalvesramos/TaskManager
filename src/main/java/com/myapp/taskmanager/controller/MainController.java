package com.myapp.taskmanager.controller;

import com.myapp.taskmanager.model.Task;
import com.myapp.taskmanager.model.TaskManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;

public class MainController {
    @FXML
    private TextField taskNameField;
    @FXML
    private DatePicker dueDatePicker;
    @FXML
    private ComboBox<String> priorityComboBox;
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, Void> statusButtonColumn;
    private TaskManager taskManager;

    public void initialize() {
        this.taskManager = new TaskManager();

        // Création des colonnes de la table des tâches.
        TableColumn<Task, String> nameColumn = new TableColumn<>("Nom");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Task, String> dueDateColumn = new TableColumn<>("Date limite");
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));

        TableColumn<Task, String> priorityColumn = new TableColumn<>("Priorité");
        priorityColumn.setCellValueFactory(new PropertyValueFactory<>("priority"));

        TableColumn<Task, String> statusColumn = new TableColumn<>("Statut");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Configure une cell factory pour la colonne de bouton de statut qui crée des boutons pour chaque cellule.
        statusButtonColumn.setCellFactory(tc -> {
            TableCell<Task, Void> cell = new TableCell<>() {
                private final Button button = new Button("Change Status");
                {
                    button.setOnAction((event) -> {
                        Task task = getTableView().getItems().get(getIndex());
                        changeStatus(task);
                    });
                }
                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    setGraphic(empty ? null : button);
                }
            };
            return cell;
        });

        taskTable.getColumns().setAll(nameColumn, dueDateColumn, priorityColumn, statusColumn, statusButtonColumn);

        // Lie la table des tâches à la liste des tâches du gestionnaire de tâches.
        taskTable.setItems(taskManager.getTasks());
    }

    @FXML
    private void addTask() {
        String taskName = taskNameField.getText();
        LocalDate dueDate = dueDatePicker.getValue();
        String priority = priorityComboBox.getValue();

        if (taskName != null && !taskName.trim().isEmpty() &&
                dueDate != null && !dueDate.isBefore(LocalDate.now()) &&
                priority != null && !priority.trim().isEmpty()) {
            System.out.println("test");
            // Créez une nouvelle tâche et ajoutez-la au gestionnaire de tâches.
            Task task = new Task(taskName, dueDate, priority);
            taskManager.addTask(task);

            // Réinitialisez les champs du formulaire.
            taskNameField.setText(null);
            dueDatePicker.setValue(null);
            priorityComboBox.setValue(null);
        }else {
            // Si les conditions ne sont pas remplies, affichez un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de saisie");
            alert.setHeaderText("Erreur de saisie");
            alert.setContentText("Veuillez vérifier vos entrées : le nom de la tâche ne doit pas être vide, la date d'échéance doit être dans le futur, et la priorité ne doit pas être vide.");
            alert.showAndWait();
        }
    }
    public void changeStatus(Task task) {
        if (task == null) {
            return;
        }

        // Changez le statut de la tâche. Pour cet exemple, je suppose que votre classe Task a une méthode pour cela.
        if (task.getStatus().equals("En cours")) {
            task.setStatus("Terminée");
        } else {
            task.setStatus("En cours");
        }
    }
}
