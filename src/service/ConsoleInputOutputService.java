package service;

import exceptions.IllegalOperation;
import java.util.Scanner;

public class ConsoleInputOutputService {

    public void readLine() throws IllegalOperation {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш пример. Между всеми элементами, кроме отрицательных чисел, должен стоять пробел.");

        ValidationService validationService = new ValidationService(scanner.nextLine());
        validationService.validate();
    }

    public void printResult(String result) {
        System.out.println("Ответ: " + result);
    }
}