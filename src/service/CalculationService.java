package service;


import exceptions.IllegalOperation;

import java.util.LinkedList;

public class CalculationService {
    private ConsoleInputOutputService consoleInputOutputService = new ConsoleInputOutputService();

    public void calculate(LinkedList<String> polandNotation) throws IllegalOperation {
        int i = 0;
        double firstOperand;
        double secondOperand;
        String operation;
        String operationCheck;
        while (!(polandNotation.size() == 1)) {
            try {
                operationCheck = polandNotation.get(i + 2);
            }catch (IndexOutOfBoundsException e){
                throw new IllegalArgumentException("Неправильно составлен пример, убедитесь в его правильности.");
            }

            if (!(operationCheck.equals("*") || operationCheck.equals("-") || operationCheck.equals("+") || operationCheck.equals("/"))) {
                i++;
            } else {
                try {
                    firstOperand = Double.parseDouble(polandNotation.remove(i));
                    secondOperand = Double.parseDouble(polandNotation.remove(i));
                    operation = polandNotation.remove(i);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Введен недопустимый символ.");
                }

                switch (operation) {
                    case "*":
                        polandNotation.add(i, multiply(firstOperand, secondOperand));
                        i = 0;
                        break;
                    case "+":
                        polandNotation.add(i, sum(firstOperand, secondOperand));
                        i = 0;
                        break;
                    case "-":
                        polandNotation.add(i, subtraction(firstOperand, secondOperand));
                        i = 0;
                        break;
                    case "/":
                        polandNotation.add(i, division(firstOperand, secondOperand));
                        i = 0;
                        break;
                }
            }
        }
        if (Double.valueOf(polandNotation.getFirst()).equals(Double.POSITIVE_INFINITY)||Double.valueOf(polandNotation.getFirst()).equals(Double.NEGATIVE_INFINITY)){
            throw new ArithmeticException("Произошла попытка деления на ноль.");
        }
        consoleInputOutputService.printResult(polandNotation.getFirst());
    }

    private String sum(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand + "";
    }

    private String subtraction(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand + "";
    }

    private String multiply(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand + "";
    }

    private String division(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand + "";
    }
}