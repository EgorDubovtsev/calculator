package service;


import exceptions.IllegalOperation;

import java.util.LinkedList;
import java.util.Stack;

public class ParsingService {
    private CalculationService calculationService = new CalculationService();
    private LinkedList<String> polandNotation = new LinkedList<>();
    private Stack<String> operations = new Stack<>();

    public void parse(String line) throws IllegalOperation {
        String[] symbols = line.split("\\s+");
        for (String element : symbols) {
            int priority = getPriority(element);
            if (priority == 0) {
                polandNotation.add(element);

            } else if (priority == 1) {
                operations.push(element);

            } else if (priority > 1) {
                while (!operations.isEmpty()) {
                    if (getPriority(operations.peek()) >= priority) {
                        polandNotation.add(operations.pop());
                    } else {
                        break;
                    }
                }
                operations.push(element);
            }
            if (priority == -1) {
                while (getPriority(operations.peek()) != 1) {
                    polandNotation.add(operations.pop());
                }
                operations.pop();
            }
        }
        while (!operations.empty()) {
            polandNotation.add(operations.pop());
        }
        calculationService.calculate(polandNotation);

    }

    public int getPriority(String operation) {
        if (operation.equals("*") || operation.equals("/")) {
            return 3;
        } else if (operation.equals("+") || operation.equals("-")) {
            return 2;
        } else if (operation.equals("(")) {
            return 1;
        } else if (operation.equals(")")) {
            return -1;
        } else {
            return 0;
        }
    }
}
