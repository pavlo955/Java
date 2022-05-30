import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String ReadFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            return bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static void WriteFile(String fileName, String[] lines) throws Exception {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for(String line: lines) {
                bufferedWriter.write(line + " ");
            }
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static String[] PairChars(String[] words)
    {
        ArrayList<String> list = new ArrayList<>();

        for(String str: words)
        {
            if(str.length() % 2 == 0)
                list.add(str);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        try {
            String line = ReadFile("input.txt");
            String[] words = line.split(" ");

            WriteFile("output.txt", PairChars(words));

            System.out.println("Записано у файл");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
