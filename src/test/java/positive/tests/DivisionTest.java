package positive.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import service.ValidationService;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
public class DivisionTest{
@RunWith(Parameterized.class)
public static class DivisionTestParametrized {

    @Parameterized.Parameters(name = "{index}: {0} \\ {1} = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{{"4", "2", "2.0"}, {"48", "2", "24.0"}, {"117", "39", "3.0"}, {"-14", "-2", "7.0"}});
    }

    private String firstOperand;

    private String secondOperand;

    private String answer;

    public DivisionTestParametrized(String firstOperand, String secondOperand, String answer) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.answer = answer;
    }

    @Test
    public void simpleDivision() throws IllegalOperation {
        ValidationService validationService = new ValidationService(firstOperand + " / " + secondOperand);
        assertEquals("Возникла ошибка при делении простых чисел.", answer, validationService.validate());
    }
}



    @Test
    public void divisionWithBrackets() throws IllegalOperation {
        ValidationService validationService = new ValidationService("48 / ( 2 + 4 )");
        assertEquals("Возникла ошибка при сложении с использованием скобок.", "8.0", validationService.validate());
    }

    @Test
    public void divisionWithDouble() throws IllegalOperation {
        ValidationService validationService = new ValidationService("256.7 / 28.7");
        assertEquals("Возникла ошибка при сложении с использованием скобок.", "8.94425087108014", validationService.validate());
    }

    @Test(expected = ArithmeticException.class)
    public void divisionByZero() throws IllegalOperation {
        ValidationService validationService = new ValidationService("25 / 0");
        validationService.validate();
    }


}
