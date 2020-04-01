package negative.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import service.ValidationService;

public class SubtractionTestNegative {
    @Test(expected = IllegalArgumentException.class)
    public void subtractionDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 -- 3");
        validationService.validate();
    }
    @Test(expected = IllegalArgumentException.class)
    public void subtractionTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService("asd - 3");
        validationService.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractionNullTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService(" ");
        validationService.validate();
    }
}