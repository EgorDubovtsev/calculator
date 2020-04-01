package negative.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import service.ValidationService;

public class DivisionTestNegative {
    @Test(expected = IllegalArgumentException.class)
    public void divisionDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 // 3");
        validationService.validate();
    }
    @Test(expected = IllegalArgumentException.class)
    public void divisionTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService("asd / 3");
        validationService.validate();
    }
    @Test(expected = ArithmeticException.class)
    public void divisionByZero() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 / 0");
        validationService.validate();
    }
    @Test(expected = IllegalArgumentException.class)
    public void divisionNullTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService(" ");
        validationService.validate();
    }
}
