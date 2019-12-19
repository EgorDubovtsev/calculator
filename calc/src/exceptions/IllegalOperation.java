package exceptions;

public class IllegalOperation extends Exception {
    public IllegalOperation() {
    }

    public IllegalOperation(String message) {
        super(message);
    }

    public IllegalOperation(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOperation(Throwable cause) {
        super(cause);
    }
}
