package Chuong2.WHILE;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double GDP2020 = sc.nextDouble();
        double GDP = GDP2020;
        double TL = sc.nextDouble();
        int year = 2020;
        do {
            System.out.println(year + " " + GDP);
            year++;
            GDP += (GDP * TL);
        } while (GDP < 2 * GDP2020);
        System.out.println(year + " " + GDP);
    }
}
