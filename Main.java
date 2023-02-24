package org.example;

import org.example.exceptions.DivisionByZeroException;
import org.example.exceptions.IncorrectArgException;
import org.example.exceptions.IncorrectOperationException;

public class Main {
    public static void main(String[] args)  {
        CalcService calcService = new CalcService();
        try {
            System.out.printf("Результат операции: %f%n", calcService.calculate());
        } catch (IncorrectArgException | DivisionByZeroException | IncorrectOperationException e) {
            e.printStackTrace();
        }
    }
}