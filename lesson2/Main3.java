package lesson1;

import java.io.IOException;

public class Main3 {
    /*
    Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
    Необходимо посчитать и вернуть сумму элементов этого массива.
    При этом накладываем на метод 2 ограничения:
    метод может работать только с квадратными массивами (кол-во строк = кол-ву столбцов),
    и в каждой ячейке может лежать только значение 0 или 1.
    Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
     */
    public static void main(String[] args) {
        int[][] array = new int[][]{
                {1,0,0},
                {1,1,0},
                {0,0,1}};
        try {
            System.out.println("Сумма элементов массива равна: " + sumElement(array));
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Конец программы");
    }

    static int sumElement(int[][] array){
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array.length != array[i].length){
                throw new RuntimeException("Массив не квадратный");
            }
            for (int j = 0; j < array[i].length; j++) {
                int item = array[i][j];
                if (item != 0 && item != 1){
                    throw new RuntimeException("элемент под индексом [" + i + ", " + j + "] " +
                            "не равен 1 или 0");
                }
                sum += item;
            }
        }
        return sum;
    }
}
