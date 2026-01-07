package Chuong6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GhiDocMang {

    public static void main(String[] args) {
        //tao file
        //ghi du lieu vao file
        File file = new File("byte_demo.dat");
//        
//        byte[] dataToWrite = {74, 97, 118, 97, 32, 66, 121, 116, 101}; //bang ma ASCII
//        
//        try(FileOutputStream fos = new FileOutputStream(file)){
//            fos.write(dataToWrite);
//        }catch(IOException e){
//            e.printStackTrace();
//        }finally{
//            System.out.println("Ghi vao file thanh cong");
//        }

        //doc file
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[(int) file.length()];
            int bytesRead = fis.read(buffer);
            System.out.println(bytesRead);

            //chuyen byte thanh String 
            String content = new String(buffer, 0, bytesRead);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Doc file thanh cong");
        }

    }
}
