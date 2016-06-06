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
        }
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? extends Number> validator) {

        if (task.getResult() != null) {
            throw new RuntimeException();
        } else {

            task.setValidator(validator);  // <------------------------------------ ERROR
            listTasks.add(task);
        }
    }

    @Override
    public void execute() {

        //listTasks.forEach(Task::execute);
        for (Task task : listTasks) {
            task.execute();
            if (task.getValidator.isValid(task.getResult())) {  // <------------------------------------ ERROR
                validResult.add(task.getResult());
            } else {
                inValidResult.add(task.getResult());
            }
        }

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


