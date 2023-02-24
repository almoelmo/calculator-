package org.example.exceptions;

public class IncorrectOperationException extends Throwable {
    @Override
    public void printStackTrace() {
        System.out.println("Ошибка! Указана неправильная математическая операция");
    }
}
