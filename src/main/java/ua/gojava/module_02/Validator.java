package ua.gojava.module_02;


public interface Validator <T> {

        // Валидирует переданое значение
        boolean isValid(T result);

}
