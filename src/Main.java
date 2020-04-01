import exceptions.IllegalOperation;
import service.ConsoleInputOutputService;

public class Main {

    public static void main(String[] args) throws IllegalOperation {
        ConsoleInputOutputService consoleInputOutputService = new ConsoleInputOutputService();
        consoleInputOutputService.readLine();
    }
}