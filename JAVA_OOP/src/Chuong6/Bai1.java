package Chuong6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Viết một chương trình Java để đọc nội dung từ một file văn bản (tạo bằng
 * Notepad) và ghi từng dòng nội dung đó vào một file mới.
 *
 * @author hoa
 */
public class Bai1 {

    private static final String filename = "bai1.txt";
    private static final String filenameCopy = "bai2.txt";

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename));
                BufferedWriter writer = new BufferedWriter(new FileWriter(filenameCopy))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finished");
        }
    }
}
