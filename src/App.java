import java.util.Scanner;

import handler.CommandHandler;
import repository.TaskRepository;
import service.TaskService;

public class App {
    public static void main(String[]args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TaskRepository taskRepository = new TaskRepository();
        TaskService taskService = new TaskService(taskRepository);
        CommandHandler commandHandler = new CommandHandler(taskService, scanner);
        commandHandler.handle();
        scanner.close();
    }
}
