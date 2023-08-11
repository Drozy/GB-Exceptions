package lesson3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomeWork {
    /*
    Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке,
    разделенные пробелом:
    Фамилия Имя Отчество дата_рождения номер_телефона пол

    Форматы данных:
    фамилия, имя, отчество - строки
    дата_рождения - строка формата dd.mm.yyyy
    номер_телефона - целое беззнаковое число без форматирования
    пол - символ латиницей f или m.
    
    Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
    вернуть код ошибки, создать метод, который обработает его и показажет пользователю сообщение,
    что он ввел меньше или больше данных, чем требуется.
    Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
    Можно использовать встроенные типы java или создать свои. Исключение должно быть корректно обработано,
    пользователю выведено сообщение с информацией, что именно неверно.
    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии.
    В него в одну строку должны записаться полученные данные, вида:
    Фамилия Имя Отчество дата_рождения номер_телефона пол
     */

    public static class UserInfoApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные (в формате: фамилия имя отчество дата_рождения номер_телефона пол):");
            String input = scanner.nextLine();
            try {
                String[] data = checkData(input);

                String lastName = checkName(data[0]);
                String firstName = checkName(data[1]);
                String middleName = checkName(data[2]);
                Date dateOfBirth = parseDate(data[3]);
                String phoneNumber = checkPhone(data[4]);
                char gender = checkGender(data[5]);

                String result = lastName + " " +
                        firstName + " " +
                        middleName + ", " +
                        formatDate(dateOfBirth) + ", " +
                        phoneNumber + ", " +
                        gender;
                saveInFile(lastName, result);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Неверный формат номера телефона");
            } catch (ParseException e) {
                System.out.println("Ошибка: Неверный формат даты");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static Date parseDate(String dateStr) throws ParseException {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.parse(dateStr);
        }

        private static String formatDate(Date date) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            return format.format(date);
        }

        private static String[] checkData(String input) {
            String[] data = input.split(" ");
            if (data.length > 6) {
                throw new IllegalArgumentException("Количество данных больше требуемого");
            } else if (data.length < 6) {
                throw new IllegalArgumentException("Количество данных меньше требуемого");
            }
            return data;
        }

        private static String checkPhone(String data) {
            if (data.matches("\\d+"))
                return data;
            else throw new NumberFormatException();
        }

        private static char checkGender(String data) {
            if (data.equals("f") || data.equals("m"))
                return data.charAt(0);
            else throw new IllegalArgumentException("Неверный формат пола");
        }

        private static String checkName(String data) {
            if (data.matches("^[а-яА-Я]*$") || data.matches("^[a-zA-Z]*$"))
                return data;
            else throw new IllegalArgumentException("ФИО содержит не только буквы");
        }
        private static void saveInFile(String filePath, String data) throws WriteInFileException {
            try (FileWriter writer = new FileWriter(filePath, true)){
                writer.write(data);
                writer.write("\n");
                writer.flush();
            } catch (IOException e){
                throw new WriteInFileException("Ошибка записи в файл ", e);
            }
        }
    }
}


