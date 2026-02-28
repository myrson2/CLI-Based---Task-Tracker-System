package handler;

import java.util.Scanner;

import exceptions.InvalidCommandException;
import exceptions.InvalidInputException;
import service.TaskService;
import util.InputUtil;

public class CommandHandler {
    private TaskService taskService;
    private Scanner scanner;

    public CommandHandler(TaskService taskService, Scanner scanner){
        this.taskService = taskService;
        this.scanner = scanner;
    }

    public void handle() throws InvalidCommandException{
        boolean isContinue = true;
        while (isContinue){
            
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
                    handleDelete();
                    break;
                
                case 4:
                    handleInProgress();
                    break;
                
                case 5:
                    handleMarkDone();
                    break;

                case 6:
                    handleList();
                    break;

                case 7:
                    handleTaskbyStatus();
                    break;
                default:
                     throw new InvalidCommandException("Command '" + choice + "' does not exist.");
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

        try {
            int ch = InputUtil.readInt("\nEnter Choice: ", scanner);
            return ch;
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
            return -1;
        }
    }

    public void handleAdd(){
        String description = InputUtil.readString("Enter Description: ", scanner);
        taskService.addTask(description);
    }
    
    public void handleUpdate(){
        try {
            int id = InputUtil.readInt("Enter ID: ", scanner);
            String description = InputUtil.readString("Enter Description: ", scanner);

            taskService.updateTask(id, description);
        } catch (InvalidInputException e) {
        System.out.println("Error: " + e.getMessage());
            }  
    }
    
    public void handleDelete(){
        try {
            int id = InputUtil.readInt("Enter ID: ", scanner);
            taskService.deleteTask(id);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public void handleInProgress(){
       try {
            int id = InputUtil.readInt("Enter ID: ", scanner);
            taskService.markInProgress(id);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }

    public void handleMarkDone(){
        try {
            int id = InputUtil.readInt("Enter ID: ", scanner);
            taskService.markDone(id);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
    
    public void handleList(){
        taskService.listTasks();
    }
    
    public void handleTaskbyStatus(){
        taskService.listTasksbyStatus();
    }
    
    public TaskService getTaskService() {
        return taskService;
    }
}
