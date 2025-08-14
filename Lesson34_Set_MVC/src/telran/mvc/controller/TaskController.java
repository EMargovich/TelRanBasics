package telran.mvc.controller;

import telran.mvc.model.entities.Task;
import telran.mvc.model.services.TaskModel;
import telran.mvc.view.TaskView;

import java.util.Scanner;

public class TaskController {

    private TaskModel model;

    private TaskView view;

    private Scanner scanner = new Scanner(System.in);

    public TaskController() {
        this.model = new TaskModel();
        this.view = new TaskView();
    }

    public void start() {

        view.showMessage("Task list (console version). Type 'help' for help.");
        while(true) {
            System.out.println(">>>");
            String input = scanner.nextLine();
            if (input == null) continue;
            input = input.trim().toLowerCase();
            if (input.isBlank())
                view.showMessage("Empty task not added! Please enter text");

            outerLoop:
            switch (input) {
                case "exit" : {
                    view.showMessage("Bye");
                    return;
                }
                case "help" : {
                    view.showHelp();
                    break;
                }
                case "list" : {
                    view.showTasks(model.getTasks());
                    break;
                }
                default: {
                    model.addTask(new Task(input));
                    view.showMessage("Task added");
                    view.showTasks(model.getTasks());
                }
            }
        }
    }
}
