package org.example;

import org.example.exceptions.DivisionByZeroException;
import org.example.exceptions.IncorrectArgException;
import org.example.exceptions.IncorrectOperationException;

import java.util.List;
import java.util.Scanner;


public class CalcService {
    private double leftArg;
    private double rightArg;
    private final List<Character> operations = List.of('+', '-', '*', '/');
    private char operation;


    public double calculate() throws IncorrectArgException, DivisionByZeroException, IncorrectOperationException {
        Scanner scanner = new Scanner(System.in);
        double result = 0;


        System.out.println("Введите математическую операцию(+, *, -, /):");
        this.operation = scanner.nextLine().charAt(0);
        System.out.println("Введите первое число:");
        String arg1 = scanner.nextLine();
        System.out.println("Введите второе число:");
        String arg2 = scanner.nextLine();


        this.check(arg1, arg2);

        switch (operation){
            case '+': result = this.sum(); break;
            case '-': result = this.diff(); break;
            case '*': result = this.multiplication(); break;
            case '/': result = this.division(); break;
        }
        return result;
    }


    private double sum(){return this.leftArg + rightArg;}


    private double diff(){return this.leftArg - this.rightArg;}


    private double multiplication(){return this.leftArg * this.rightArg;}


    private double division(){return this.leftArg / this.rightArg;}


    private void check(String leftArg, String rightArg) throws IncorrectOperationException, DivisionByZeroException, IncorrectArgException {

        if(!this.operations.contains(this.operation)){
            throw new IncorrectOperationException();
        }


        try{
            this.leftArg = Double.parseDouble(leftArg);
            this.rightArg = Double.parseDouble(rightArg);
        } catch (NumberFormatException e) {
            throw new IncorrectArgException();
        }


        if(this.operation == '/' && this.rightArg == 0){
            throw new DivisionByZeroException();
        }
    }
}
