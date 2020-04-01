package positive.tests;

import exceptions.IllegalOperation;
import org.junit.Test;

public class ExceptionTest {
    @Test(expected = IllegalOperation.class)
    public void IllegalOperationTest() throws IllegalOperation {
        throw new IllegalOperation("Test");
    }
    @Test(expected = IllegalOperation.class)
    public void IllegalOperationTestWithoutParam() throws IllegalOperation {
        throw new IllegalOperation();
    }
}
