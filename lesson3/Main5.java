package lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    /*
    Запишите в файл следующие строки:
    Анна=4
    Елена=5
    Марина=6
    Владимир=?
    Константин=?
    Иван=4
    Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив
    (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных,
    если сохранено значение ?, заменить его на соответствующее число. Если на каком-то месте встречается символ,
    отличный от числа или ?, бросить подходящее исключение.
    Записать в тот же файл данные с замененными символами ?.
     */
    static Map<String, String> map;

    public static void main(String[] args) {
        readAndWrite();
    }

    private static void readAndWrite() {
        try {
            readFile("test.txt");
            replace();
            saveInFile("test1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println("В файле некорректные значения");
            System.out.println(e.getMessage());
        }
    }

    static void saveInFile(String filePath) throws WriteInFileException {
        try (FileWriter writer = new FileWriter(filePath)){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writer.write(entry.toString());
                writer.write("\n");
                writer.flush();
            }
        } catch (IOException e){
            throw new WriteInFileException("Ошибка связанная с сохранением", e);
        }
    }

    static void replace() throws IllegalArgumentException {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            if (val.equals("?")) {
                entry.setValue(String.valueOf(key.length()));
            } else if (!val.matches("[0-9]+")) {
                throw new IllegalArgumentException("Проблема на строке: " + entry);
            }
        }
    }

    static Map<String, String> readFile(String filePath) throws ReadFileException {
        map = new LinkedHashMap<>();
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] strings = line.split("=");
                if (strings.length != 2) {
                    throw new IllegalArgumentException("ошибка на строке: " + line);
                }
                map.put(strings[0], strings[1]);
            }
        } catch (IOException e){
            throw new ReadFileException("Ошибка связанная с загрузкой", e);
        }
        return map;
    }
}
