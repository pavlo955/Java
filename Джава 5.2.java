import java.io.*;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> ReadFile(String fileName) throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            ArrayList<String> result = new ArrayList<>();

            String line = bufferedReader.readLine();
            while (line != null)
            {
                result.add(line);
                line = bufferedReader.readLine();
            }
            return result;
        } catch (FileNotFoundException e) {
            throw new Exception("Файл не існує!");
        } catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }
    }

    public static void WriteFileTask(String fileName, ArrayList<String> lines) throws Exception {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for (String line: lines) {
                if(Integer.parseInt(line) % 2 == 0)
                    bufferedWriter.write(line + "\n");
            }
        }
        catch (NumberFormatException e) {
            FileWriter pw = new FileWriter(fileName);
            pw.close();
            throw new Exception("Не всі значення в файлі є цілими числами.");
        }
        catch (IOException e) {
            throw new Exception("Помилка: " + e.getMessage());
        }

        System.out.println("Результат записано");
    }

    public static void main(String[] args) {
        try {
            ArrayList<String> lines = ReadFile("f.txt");
            WriteFileTask("g.txt", lines);
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
}
