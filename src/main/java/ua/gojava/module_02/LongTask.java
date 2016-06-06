package ua.gojava.module_02;

import java.util.Arrays;
import java.util.List;


public class LongTask implements Task<Long> {
    Long value;
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
}
