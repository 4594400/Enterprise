package ua.gojava.module_02;


public class IntegerTask<Integer> implements Task<Integer>{
    Integer value;
    Validator<Integer> validator = null;
    Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    public IntegerTask(Integer value, Validator<Integer> validator) {
        this.value = value;
        this.validator = validator;
    }

    @Override
    public void execute() {
        result = value * 10;
    }  // <----------------------------- ERROR

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    public Validator<Integer> getValidator() {
        return validator;
    }

    public void setValidator(Validator<Integer> validator) {
        this.validator = validator;
    }
}
