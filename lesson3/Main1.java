package lesson3;

import java.io.IOException;

public class Main1 {
    /*
    Создайте метод doSomething(), который может быть источником одного из типов checked exceptions
    (тело самого метода прописывать не обязательно).
    Вызовите этот метод из main и обработайте в нем исключение, которое вызвал метод doSomething().
     */
    public static void main(String[] args) {
        try {
            doSomething();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void doSomething() throws IOException {

    }
}
