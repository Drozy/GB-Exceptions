package lesson1;

import java.util.Scanner;

public class Main2 {
    /*
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
    Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
    если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
    если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
    если вместо массива пришел null, метод вернет -3
    придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
    Напишите метод, в котором реализуйте взаимодействие с пользователем.
    То есть, этот метод запросит искомое число у пользователя, вызовет первый,
    обработает возвращенное значение и покажет читаемый результат пользователю.
    Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число для поиска в массиве: ");
        int number = input.nextInt();
        int[] array = new int[] {1, 2, 3, 4, 5, 6};
        decoder(indexOfNumber(null, number));
        input.close();

    }

    public static int indexOfNumber(int[] array, int userNumber) {
        int minLength = 5;
        if (array == null) {
            return -3;
        }
        if (array.length < minLength) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == userNumber) {
                return i;
            }
        }
        return -2;
    }

    public static void decoder(int code) {
        switch (code) {
            case -1:
                System.out.println("Длина массива меньше 5 элементов");
                break;
            case -2:
                System.out.println("Искомый элемент не найден");
                break;
            case -3:
                System.out.println("Массив равен null");
                break;
            default:
                System.out.printf("Индекс элемента равен %d", code);
        }
    }
}

