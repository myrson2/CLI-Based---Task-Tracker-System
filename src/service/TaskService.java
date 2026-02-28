package service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import exceptions.FileStorageException;
import exceptions.TaskNotFoundException;
import model.Status;
import model.Task;
import repository.TaskRepository;
import util.DateTimeUtil;
import util.IDGeneratorUtil;

public class TaskService {
    private Task task;
    private TaskRepository taskRepository;
    private List<Task> tasks = new ArrayList<>();

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    // ------- Methods ---------
    public void addTask(String description) {
        int id = IDGeneratorUtil.generateId();
        String createdAt = DateTimeUtil.createdAt();
        String updatedAt = DateTimeUtil.createdAt();

        task = new Task(id, description, Status.TODO, createdAt, updatedAt);
        tasks.add(task);
        try {
            taskRepository.saveTask(task);
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateTask(int id, String description){
        ListIterator<Task> allTask = tasks.listIterator();

        while(allTask.hasNext()){
            Task t = allTask.next();

            if(id == t.getId()){
                t.setDescription(description);
                t.setId(id);
                t.setUpdatedAt(DateTimeUtil.createdAt());
                allTask.set(t);
            }
        }

        try {
            taskRepository.updateTask(tasks);
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteTask(int id){
        ListIterator<Task> allTask = tasks.listIterator();

        while(allTask.hasNext()){
            Task t = allTask.next();

            if(id == t.getId()){
                allTask.remove();
            }
        }

        try {
            taskRepository.deleteTask(tasks);
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void markInProgress(int id){
        ListIterator<Task> allTask = tasks.listIterator();

        while(allTask.hasNext()){
            Task t = allTask.next();

            if(id == t.getId()){
                t.setStatus(Status.IN_PROGRESS);
            }
        }

        try {
            taskRepository.updateTask(tasks);
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void markDone(int id){
        ListIterator<Task> allTask = tasks.listIterator();

        while(allTask.hasNext()){
            Task t = allTask.next();

            if(id == t.getId()){
                t.setStatus(Status.DONE);
            }
        }
        
        try {
            taskRepository.updateTask(tasks);
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listTasks(){
        try {
            taskRepository.loadTask();
        } catch (FileStorageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void listTasksbyStatus(){
        System.out.println("Tasks: ");
        System.out.println("TODO: ");
        
        for (Task task : tasks) {
            if(task.getStatus() == Status.TODO){
                System.out.println(task.toFileString());
            }
        }

        System.out.println("\nIn Progress: ");
        for (Task task : tasks) {
            if(task.getStatus() == Status.IN_PROGRESS){
                System.out.println(task.toFileString());
            }
        }

         System.out.println("\nDone: ");
        for (Task task : tasks) {
            if(task.getStatus() == Status.DONE){
                System.out.println(task.toFileString());
            }
        }
    }

    public boolean idChecker(int id) throws TaskNotFoundException{
        ListIterator<Task> allTask = tasks.listIterator();

        while(allTask.hasNext()){
            Task t = allTask.next();

            if(id == t.getId()){
                return true;
            }
        }
        throw new TaskNotFoundException("Task Not Found.");
    }

    // ------ Getters --------
    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
