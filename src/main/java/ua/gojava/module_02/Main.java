package ua.gojava.module_02;


public class Main {
    public static void main(String[] args) {
        Executor<Number> numberExecutor = new ExecutorImpl();
        numberExecutor.addTask(new IntegerTask(5));

        numberExecutor.addTask(new IntegerTask(150));
        numberExecutor.addTask(new IntegerTask(10));
        numberExecutor.addTask(new IntegerTask(200));

        numberExecutor.addTask(new LongTask(-500L), new NumberValidator());
        numberExecutor.addTask(new IntegerTask(-5), new NumberValidator());
        numberExecutor.addTask(new IntegerTask(7), new NumberValidator());


        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }


    }
}
