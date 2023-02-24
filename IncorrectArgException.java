package org.example.exceptions;

public class IncorrectArgException extends Throwable {
    @Override
    public void printStackTrace() {
        System.out.println("Ошибка! Один из аргументов не является числом");
    }
}
