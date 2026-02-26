package service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import model.Status;
import model.Task;
import repository.TaskRepository;
import util.DateTimeUtil;
import util.IDGeneratorUtil;

public class TaskService {
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

        Task task = new Task(id, description, Status.TODO, createdAt, updatedAt);
        tasks.add(task);
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
    }

    public void details(){
        for(Task t : tasks){
            System.out.println(t.details());
        }
    }

    // ------ Getters --------
    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
