import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Deshifrator {
    private static final String INPUT_FILE = "src/MyFiles/source.txt";
    private static final String OUTPUT_FILE = "src/MyFiles/result.txt";

    public static void main(String[] args) {
        // список прийменників
        String myRegExpression = "\\b(in|on|at|to|from|with|by|about|under|over|before|after|between|into|through|during|without|against|among|for|of|off)\\b";
        Pattern pattern = Pattern.compile(myRegExpression, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        // Вказуємо кодування UTF-8 для читання та запису
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new FileInputStream(INPUT_FILE), StandardCharsets.UTF_8));
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream(OUTPUT_FILE), StandardCharsets.UTF_8))) {

            String sourceLine;

            while ((sourceLine = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(sourceLine);
                String resultLine = matcher.replaceAll("Java");
                bufferedWriter.write(resultLine);
                bufferedWriter.newLine();
            }
            System.out.println();
            System.out.println("Результат збережено у: " + new File(OUTPUT_FILE).getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Помилка при роботі з файлом!");
        }
    }
}