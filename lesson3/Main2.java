package lesson3;

import java.io.IOException;

public class Main2 {
    /*
    Создайте класс Счетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1.
    Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources.
    Подумайте, что должно происходить при закрытии этого ресурса?
    Напишите метод для проверки, закрыт ли ресурс. При попытке вызвать add() у закрытого ресурса,
    должен выброситься IOException
     */
    public static void main(String[] args) {
        try (Counter counter = new Counter()){
            counter.add();
            counter.add();
            System.out.println(counter.getCount());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
