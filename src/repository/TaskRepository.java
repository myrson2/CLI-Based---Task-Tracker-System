package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import model.Task;

public class TaskRepository {
    File taskFiles = new File("data/tasks.txt");

    public void loadTask(){
        try(BufferedReader reader = new BufferedReader(new FileReader(taskFiles))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTask(Task task) {
        boolean append = !createFile(taskFiles); // Assuming createFile returns true if file was created
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles, append))) {
            String format = task.toFileString();
            writer.write(format);
            writer.newLine(); // Adds a newline after each task
        } catch (IOException e) {   
            // Handle error appropriately, e.g., log or throw
            throw new RuntimeException("Failed to save task", e);
        }
    }   

    public void updateTask(List<Task> task) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
            for (Task t : task) {
                writer.write(t.toFileString());
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteTask(List<Task> task) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
            for (Task t : task) {
                writer.write(t.toFileString());
                writer.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Boolean createFile(File taskFile){
            if(taskFiles.exists()){
                return false;
            }
            return true;
        } 
    }

