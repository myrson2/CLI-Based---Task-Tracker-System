package handler;

import java.time.LocalDateTime;
import java.util.Scanner;

import model.Status;
import service.TaskService;
import util.DateTimeUtil;
import util.IDGeneratorUtil;
import util.InputUtil;

public class CommandHandler {
    private TaskService taskService;
    private Scanner scanner;

    public CommandHandler(TaskService taskService, Scanner scanner){
        this.taskService = taskService;
        this.scanner = scanner;
    }

    public void handle(){
        boolean isContinue = true;
        while (isContinue){
            taskService.details();
            
            int choice = handleMenu(scanner);
            
            switch (choice) {
                case 0:
                    isContinue = false;
                    break;
                
                case 1:
                    handleAdd();
                    break;
                
                case 2:
                    handleUpdate();
                    break;
                
                case 3:
                    
                    break;
                
                case 4:
                    
                    break;
                
                case 5:
                    
                    break;

                case 6:
                    
                    break;

                case 7:
                    
                    break;
                default:
                    break;
            }
        }
    }

    public int handleMenu(Scanner scanner){
        System.out.println("1. Add Tasks");
        System.out.println("2. Update tasks");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Tasks as in-progress");
        System.out.println("5. Mark Tasks as done");
        System.out.println("6. List All Task");
        System.out.println("7. Filter Task by status");

        int ch = InputUtil.readInt("\nEnter Choice: ", scanner);
        return ch;
        
    }

    public void handleAdd(){
        
        String description = InputUtil.readString("Enter Description: ", scanner);

        taskService.addTask(description);
    }
    
    public void handleUpdate(){
        int id = InputUtil.readInt("Enter ID: ", scanner);
        String description = InputUtil.readString("Enter Description: ", scanner);

        taskService.updateTask(id, description);
    }
    
    public TaskService getTaskService() {
        return taskService;
    }
}
