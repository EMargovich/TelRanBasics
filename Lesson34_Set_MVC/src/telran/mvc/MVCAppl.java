package telran.mvc;

import telran.mvc.controller.TaskController;

public class MVCAppl {
    public static void main(String[] args) {
        TaskController controller = new TaskController();
        controller.start();
    }
}
