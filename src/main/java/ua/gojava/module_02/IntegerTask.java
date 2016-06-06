package ua.gojava.module_02;


public class IntegerTask implements Task<Integer>{
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
        result =  value * 10;
    }  // <----------------------------- ERROR

    @Override
    public Integer getResult() {
        return result;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer getValidator() {
        return null;
    }

    public void setValidator(Validator<Integer> validator) {
        this.validator = validator;
    }

    //    @Override
//    public void setValidator(Validator<Integer> validator) {
//        this.validator = validator;
    }

    /*@Override
    public void setValidator(Validator<Integer> value) {
        this.validator = value;
    }
*/



   /* public Validator<Integer> getValidator() {
        return validator;
    }*/

    /*public void setValidator(Validator<Integer> validator) {
        this.validator = validator;
    }*/
}
