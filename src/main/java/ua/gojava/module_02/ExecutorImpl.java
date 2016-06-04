package ua.gojava.module_02;

import java.util.ArrayList;
import java.util.List;


public class ExecutorImpl implements Executor {

    List validResult = new ArrayList<>();
    List inValidResult = new ArrayList<>();


    @Override
    public void addTask(Task task) {

    }

    @Override
    public void addTask(Task task, Validator validator) {

    }

    @Override
    public void execute() {

    }

    @Override
    public List getValidResults() {
        return validResult;
    }

    @Override
    public List getInvalidResults() {
        return inValidResult;
    }



    private class IntegerValidator implements Validator<Integer> {

        @Override
        public boolean isValid(Integer result) {
            return (result > Integer.MIN_VALUE && result < Integer.MAX_VALUE) ? true : false;
        }
    }


}
