package lesson3;

import java.io.IOException;

public class Counter implements AutoCloseable{
    /*
    Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1.
    Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
    Подумайте, что должно происходить при закрытии этого ресурса?
    Напишите метод для проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса,
    должен выброситься IOException
     */
    private int count;
    private boolean closed;

    public void add() throws IOException {
        if (closed){
            throw new IOException("Ресурс недоступен");
        }
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        closed = true;
        System.out.println("Закрыли!");
    }
}
