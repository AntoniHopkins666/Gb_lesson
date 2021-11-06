/**
 * java core. Homework 5
 *
 * @version 05 nov 2021
 * @autor Anton_Mahin
 * <p>
 * <p>
 * 1. Реализовать сохранение данных в csv файл;
 * 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
 * Структура csv файла:
 * | Строка заголовок с набором столбцов |
 * | Набор строк с целочисленными значениями |
 * | * Разделитель между столбцами - символ точка с запятой (;) |
 * <p>
 * Пример:
 * Value 1;Value 2;Value 3
 * 100;200;123
 * 300,400,500
 * Для хранения данных использовать класс вида:
 * public class AppData {
 * private String[] header;
 * private int[][] data;
 * <p>
 * // ...
 * }
 * Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 **/
import java.util.Arrays;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class lesson5 {

    public static void main(String[] args) {
        String[] header = new String[]{"Value 1", "Value 2", "Value 3"};
        int[][] data = new int[][]{{100, 200, 300}, {400, 500, 600}, {700, 800, 900}, {700, 800, 900}};

        AppData appData = new AppData(header, data);

        appData.save();
        appData.read();
    }
}

class AppData {

    private String[] header;
    private int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "header=" + Arrays.toString(header) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public void save() {
        try (BufferedWriter in = new BufferedWriter(new FileWriter("test.csv"))) {

            for (int i = 0; i <= this.header.length - 1; i++) {
                if (i < this.header.length - 1) {
                    in.write(this.header[i] + ";");
                } else {
                    in.write(this.header[i] + "\n");
                }
            }

            for (int i = 0; i <= this.data.length - 1; i++) {
                for (int j = 0; j <= this.data[i].length - 1; j++) {
                    String row = String.valueOf(data[i][j]);
                    if (j < this.data[i].length - 1) {
                        in.write(row + ";");
                    } else {
                        in.write(row + "\n");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read() {

        try (BufferedReader br = new BufferedReader(new FileReader("test.csv"))) {

            List<String[]> rows = new ArrayList<>(); // создаем лист для хранения массивов строк из файла
            String row; // обычная переменная строка, в которую мы будем считывать файл


            while ((row = br.readLine()) != null) { // здесь двойные кавычки: 1) в переменную row мы записываем
                // считанную из файла строку через метод br.readLine()
                // 2) выполянем до тех пор, пока есть значение, т.е. != null
                rows.add(row.split(";")); // делаем разделение строки через метод split (получаем массив String)
            }

            // Итого у нас получается rows - это List, который содержит в себе массивы String
            // размер List равен количеству строк (size)

            header = rows.get(0); // header - массив String, соотв-но мы записываем туда значение 0-го элемента List
            rows.remove(0); // и удаляем эту строку

            data = new int[rows.size()][header.length]; // определаем массив int, который имеет высоту (количество строк)
            // как в List, т.е. rows.size(), а длина массива String (количество элементов) = длине header

            for (int i = 0; i < rows.size(); i++) {
                String[] strings = rows.get(i);
                for (int j = 0; j < strings.length; j++) {
                    data[i][j] = Integer.parseInt(strings[j]);
                }
            }
            System.out.println("Загружено из файла:");
            System.out.println(Arrays.toString(header));
            System.out.println(Arrays.deepToString(data));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}