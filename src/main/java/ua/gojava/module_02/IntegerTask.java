package ua.gojava.module_02;


public class IntegerTask implements Task<Integer>{
    Integer value;
    Validator<Number> validator = null;
    Integer result;

    public IntegerTask(Integer value) {
        this.value = value;
    }

    public IntegerTask(Integer value, Validator<Number> validator) {
        this.value = value;
        this.validator = validator;
    }

    @Override
    public void execute() {
        result =  value * 10;
    }

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Validator<Number> getValidator() {
        return validator;
    }

    @Override
    public void setValidator(Validator<Number> validator) {
        this.validator = validator;
    }
}

