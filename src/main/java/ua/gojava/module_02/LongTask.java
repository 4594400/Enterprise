package ua.gojava.module_02;

import java.util.Arrays;
import java.util.List;


public class LongTask implements Task<Long> {

    public LongTask(Long value) {
        this.value = value;
    }

    Long value;
    Long result;
    //List <Long> longs = Arrays.asList(10L, 20L, 30L, 40L, 50L) ;

    @Override
    public void execute() {
        result = value * 50;

    }

    @Override
    public Long getResult() {
        return result;
    }
}
