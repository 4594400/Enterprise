package ua.gojava.module_02;


public class IntegerTask implements Task<Integer>{
    Integer value;
    Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    @Override
    public void execute() {
        result = value - 50;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
