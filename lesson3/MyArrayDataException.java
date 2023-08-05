package lesson3;

public class MyArrayDataException extends IllegalArgumentException {
    private int i, j;
    private static final String MESSAGE = "Неверные данные в элементе массива";

    public MyArrayDataException(int i, int j, String item) {
        this("Неверный элемент: \"" + item + "\" под индексом [" + i + ", " + j + "]");
        this.i = i;
        this.j = j;
    }

    public MyArrayDataException() {
        this(MESSAGE);
    }

    public MyArrayDataException(String s) {
        super(s);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
