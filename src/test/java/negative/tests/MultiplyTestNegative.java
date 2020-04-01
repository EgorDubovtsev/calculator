package negative.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import service.ValidationService;

public class MultiplyTestNegative {
    @Test(expected = IllegalArgumentException.class)
    public void multiplyDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 ** 3");
        validationService.validate();
    }
    @Test(expected = IllegalArgumentException.class)
    public void multiplyTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService("asd * 3");
        validationService.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyNullTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService(" ");
        validationService.validate();
    }
}
