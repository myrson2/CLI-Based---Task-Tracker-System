package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import exceptions.FileStorageException;
import model.Task;

public class TaskRepository {
    File taskFiles = new File("data/tasks.txt");

    public void loadTask() throws FileStorageException {
        try (BufferedReader reader = new BufferedReader(new FileReader(taskFiles))) {
            String line;

            System.out.println("Todo list: ");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to load tasks: " + e.getMessage());
        }
    }

    public void saveTask(Task task) throws FileStorageException {
        boolean append = !createFile(taskFiles);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles, append))) {
            String format = task.toFileString();
            writer.write(format);
            writer.newLine();
        } catch (IOException e) {
            throw new FileStorageException("Failed to save task: " + e.getMessage());
        }
    }

    public void updateTask(List<Task> task) throws FileStorageException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
        for (Task t : task) {
            writer.write(t.toFileString());
            writer.newLine();
        }
    } catch (IOException e) {
        throw new FileStorageException("Failed to update task: " + e.getMessage());
    }
}

    public void deleteTask(List<Task> task) throws FileStorageException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
            for (Task t : task) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to delete task: " + e.getMessage());
        }
    }

    private Boolean createFile(File taskFile){
            if(taskFiles.exists()){
                return false;
            }
            return true;
        } 
    }

