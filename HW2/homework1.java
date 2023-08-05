package lesson2;

import java.util.Scanner;

public class homework1 {
    public static void main(String[] args) {
        System.out.println(inputFloat());
    }

    public static float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дробное число: ");
        if (scanner.hasNextFloat()) {
            return scanner.nextFloat();
        } else {
            System.out.println("Указано неверное значение!");
            return inputFloat();
        }
    }
}
