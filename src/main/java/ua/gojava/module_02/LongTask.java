package ua.gojava.module_02;

import java.util.Arrays;
import java.util.List;


public class LongTask implements Task<Long> {
    Long value;
    Validator<Number> validator = null;
    Long result;

    public LongTask(Long value) {
        this.value = value;
    }



    @Override
    public void execute() {
        result = value - 50;
    }

    @Override
    public Long getResult() {
        return result;
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public Validator getValidator() {
        return validator;
    }

    @Override
    public void setValidator(Validator<Number> validator) {
        this.validator = validator;
    }
}
