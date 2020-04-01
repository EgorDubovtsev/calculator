package positive.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.ValidationService;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MultiplyTest {
    @RunWith(Parameterized.class)
    public static class MultiplyTestParametrized {

        @Parameterized.Parameters(name = "{index}: {0} * {1} = {2}")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][]{{"4", "2", "8.0"}, {"48", "2", "96.0"}, {"117", "39", "4563.0"}, {"-14", "-2", "28.0"}});
        }

        private String firstOperand;

        private String secondOperand;

        private String answer;

        public MultiplyTestParametrized(String firstOperand, String secondOperand, String answer) {
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
            this.answer = answer;
        }

        @Test
        public void simpleMultiply() throws IllegalOperation {
            ValidationService validationService = new ValidationService(firstOperand + " * " + secondOperand);
            assertEquals("Возникла ошибка при делении простых чисел.", answer, validationService.validate());
        }
    }

    @Test
    public void multiplyWithBrackets() throws IllegalOperation {
        ValidationService validationService = new ValidationService("3 * 2 * ( 2 * 2 )");
        assertEquals("Возникла ошибка при умножении c использованием скобок.", "24.0", validationService.validate());
    }
    @Test
    public void multiplyWithNegativeNumbers() throws IllegalOperation {
        ValidationService validationService = new ValidationService("-3 * -2 * ( 2 * -2 )");
        assertEquals("Возникла ошибка при умножении c использованием скобок.", "-24.0", validationService.validate());

        validationService = new ValidationService("-3 * 2 * 2");
        assertEquals("Возникла ошибка при умножении c использованием скобок.", "-12.0", validationService.validate());
    }
    @Test
    public void multiplyWithDouble() throws IllegalOperation {
        ValidationService validationService = new ValidationService("3.3 * 2.3");
        assertEquals("Возникла ошибка при умножении дробных чисел.", "7.589999999999999", validationService.validate());
    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplyDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 ** 3");
        validationService.validate();
    }

}
