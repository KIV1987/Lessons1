package lesson8;

public class NegativeNumberException extends Exception{
    public NegativeNumberException() {
    }

    public NegativeNumberException(String message) {
        super(message);
    }
}