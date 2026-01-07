package Chuong5;

import java.util.Scanner;

class AgeException extends Exception {

    public AgeException(String message) {
        super(message);
    }
}

public class TuyChinhNgoaiLe {

    public static void checkAge(int age) {
        try {
            if (age < 18) {
                //loi
                throw new AgeException("Tuoi phai >= 18");
            } else {
                System.out.println("Tuoi hop le");
            }
        } catch (AgeException e) {
            System.err.println("Loi da duoc xu li tai cho : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap tuoi : ");
        int age = sc.nextInt();
        checkAge(age);
        System.out.println("Chuong trinh van ...");
    }
}
