package ua.gojava.module_02;

import java.util.ArrayList;
import java.util.List;


public class ExecutorImpl implements Executor<Number> {

    List<Task> listTasks = new ArrayList<>();
    List<Number> validResult = new ArrayList<>();
    List<Number> inValidResult = new ArrayList<>();
    boolean check = false;


    // Adding without validation
    @Override
    public void addTask(Task<? extends Number> task) {
        if (task.getResult() != null) {
            throw new RuntimeException();
        } else {
            listTasks.add(task);
            task.execute();
            validResult.add(task.getResult());
        }
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) {
        if (task.getResult() != null) {
            throw new RuntimeException();
        } else {
            listTasks.add(task);
            task.execute();
            if (validator.isValid(task.getResult())) {
                validResult.add(task.getResult());
            } else {
                task.execute();
                inValidResult.add(task.getResult());
            }
        }
    }

    @Override
    public void execute() {
        listTasks.forEach(Task::execute);
        check = true;
    }

    @Override
    public List<Number> getValidResults() {
        if (!check) {
            throw new RuntimeException();
        }
        return validResult;
    }

    @Override
    public List<Number> getInvalidResults() {
        if (!check) {
            throw new RuntimeException();
        }
        return inValidResult;
    }
}


