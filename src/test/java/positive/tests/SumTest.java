package positive.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.ValidationService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SumTest {
    @RunWith(Parameterized.class)
    public static class SumTestParametrized {

        @Parameterized.Parameters(name = "{index}: {0} + {1} = {2}")
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][]{{"4", "3", "7.0"}, {"48", "6", "54.0"}, {"117", "39", "156.0"}, {"-14", "2", "-12.0"}});
        }

        private String firstOperand;

        private String secondOperand;

        private String answer;

        public SumTestParametrized(String firstOperand, String secondOperand, String answer) {
            this.firstOperand = firstOperand;
            this.secondOperand = secondOperand;
            this.answer = answer;
        }

        @Test
        public void simpleSum() throws IllegalOperation {
            ValidationService validationService = new ValidationService(firstOperand + " + " + secondOperand);
            assertEquals("Возникла ошибка при делении простых чисел.", answer, validationService.validate());
        }
    }
    @Test
    public void sumWithBrackets() throws IllegalOperation {
        ValidationService validationService = new ValidationService("2 + ( 42 + 23 )");
        assertEquals("Возникла ошибка при сложении с использованием скобок.", "67.0", validationService.validate());
    }
    @Test
    public void sumWithDouble() throws IllegalOperation {
        ValidationService validationService = new ValidationService("2.3 + 28.7 + 5.7");
        assertEquals("Возникла ошибка при сложении с использованием скобок.", "36.7", validationService.validate());
    }
    @Test
    public void sumWithNegativeNumbers() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 + 34 + ( -3 )");
        assertEquals("Возникла ошибка при сложении с использованием отрицательных чисел.", "55.0", validationService.validate());
    }
    @Test(expected = IllegalArgumentException.class)
    public void sumDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 ++ 3");
        validationService.validate();
    }
}
