package repository;

import java.io.File;
import java.util.List;

import exceptions.FileStorageException;
import model.Task;
import util.FileUtil;

public class TaskRepository {
    File taskFiles = new File("data/tasks.txt");

    public void loadTask() throws FileStorageException {
        FileUtil.loadToFile(taskFiles);
    }

    public void saveTask(Task task) throws FileStorageException {
        boolean append = !FileUtil.createFile(taskFiles);
        FileUtil.writeToFile(taskFiles, task.toFileString(), append);
    }

    public void updateTask(List<Task> task) throws FileStorageException {
        FileUtil.updateToFile(taskFiles, task);
    }

    public void deleteTask(List<Task> task) throws FileStorageException {
        FileUtil.deleteToFile(taskFiles, task);
    }
}
