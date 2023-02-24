package org.example.exceptions;

public class DivisionByZeroException extends Throwable {
    @Override
    public void printStackTrace() {
        System.out.println("Ошибка! Второй аргумент не должен равняться нулю");
    }
}
