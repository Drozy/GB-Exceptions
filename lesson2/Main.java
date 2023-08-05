package lesson1;

public class Main {
    /*
    Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
    Если длина массива меньше некоторого заданного минимума, метод возвращает -1,
    в качестве кода ошибки, иначе - длину массива.
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(length(arr));
    }

    static int length (int[] arr){
        int minLength = 5;
        if (arr.length < minLength){
            return -1;
        }
        return arr.length;
    }
}
