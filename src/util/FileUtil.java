package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import exceptions.FileStorageException;
import model.Task;

public class FileUtil {
    public static boolean createFile(File taskFile){
        if(taskFile.exists()){
                return false;
            }
            return true;
    }

    public static void loadToFile(File taskFiles) throws FileStorageException{
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

    public static void writeToFile(File taskFiles, String content, boolean append) throws FileStorageException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles, append))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            throw new FileStorageException("Failed to write to file: " + e.getMessage());
        }
    }

    public static void updateToFile(File taskFiles, List<Task> task) throws FileStorageException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
            for (Task t : task) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to update task: " + e.getMessage());
        }
    }

    public static void deleteToFile(File taskFiles, List<Task> task) throws FileStorageException{
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(taskFiles))) {
            for (Task t : task) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new FileStorageException("Failed to delete task: " + e.getMessage());
        }
    }
}
