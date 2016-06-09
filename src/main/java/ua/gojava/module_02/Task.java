package ua.gojava.module_02;

public interface Task <T> {

    // Метода запускает таск на выполнение
    void execute();

    // Возвращает результат выполнения
    T getResult();

    T getValue();

    T getValidator();
    void setValidator(Validator <T> validator);

}
