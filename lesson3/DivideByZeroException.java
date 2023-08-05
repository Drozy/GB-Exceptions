package lesson3;

public class DivideByZeroException extends ArithmeticException{
    private static final String MESSAGE = "Нельзя делить на ноль!";

    public DivideByZeroException() {
        this(MESSAGE);
    }

    public DivideByZeroException(String s) {
        super(s);
    }
}
