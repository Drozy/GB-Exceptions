package lesson2;

import java.util.Scanner;

public class homework4 {
    public static void main(String[] args) {
        String data = inputData();
        System.out.println("Вы ввели:\n" + data);
    }

    public static String inputData() {
        Scanner scanner = new Scanner(System.in);
        String str = "";
        System.out.println("Введите данные: ");
        if (scanner.hasNext()) {
            str = scanner.nextLine();
            if (str != "") {
                return str;
            } else {
                System.out.println("Пустые строки вводить нельзя!");
                return inputData();
            }
        } else {
            System.out.println("Ошибка ввода.");
            return inputData();
        }
    }
}

