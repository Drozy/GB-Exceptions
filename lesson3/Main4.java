package lesson3;

import java.util.Arrays;

public class Main4 {
    /*
    Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
    При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
    Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
    Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или
    текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией,
    в какой именно ячейке лежат неверные данные.
    В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
    и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали
    на вход корректный массив).
     */
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"1", "2", "3", "4"},
                {"1", "2", "3", "s"},
                {"1", "2", "d", "4"},
                {"1", "2", "d", "4"}
        };
        while (true) {
            try {
                System.out.println(sumElementsArray(arr));
                break;
            } catch (MyArrayDataException e){
                arr[e.getI()][e.getJ()] = "0";
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        for (String[] item: arr){
            System.out.println(Arrays.toString(item));
        }
    }

    static int sumElementsArray(String[][] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("на вход подан пустой массив");
        }

        int requireSize = 4;
        int sum = 0;

        if (arr.length != requireSize) {
            throw new MyArraySizeException(requireSize, arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != requireSize) {
                throw new MyArraySizeException(requireSize, i, arr[i].length);
            }
            for (int j = 0; j < arr[i].length; j++) {
                String item = arr[i][j];
                if (!item.matches("\\d+")) {
                    throw new MyArrayDataException(i, j, item);
                }
                sum += Integer.parseInt(item);
            }
        }
        return sum;
    }
}
