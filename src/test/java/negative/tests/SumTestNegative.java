package negative.tests;

import exceptions.IllegalOperation;
import org.junit.Test;
import service.ValidationService;

public class SumTestNegative {
    @Test(expected = IllegalArgumentException.class)
    public void sumDoubleOperation() throws IllegalOperation {
        ValidationService validationService = new ValidationService("24 ++ 3");
        validationService.validate();
    }
    @Test(expected = IllegalArgumentException.class)
    public void sumTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService("asd + 3");
        validationService.validate();
    }

    @Test(expected = IllegalArgumentException.class)
    public void sumNullTest() throws IllegalOperation {
        ValidationService validationService = new ValidationService(" ");
        validationService.validate();
    }
}
