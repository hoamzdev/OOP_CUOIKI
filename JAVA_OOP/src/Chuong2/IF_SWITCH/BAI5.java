package Chuong2.IF_SWITCH;

import java.util.Scanner;

public class BAI5 {
    private static boolean namNhuan(int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int year = sc.nextInt();
        switch (month){
            case 1,3,5,7,8,10,12 -> System.out.printf("Tháng %d năm %d có 31 ngày",month,year);
            case 2 -> {
                if(namNhuan(year)) System.out.printf("Tháng %d năm %d có 29 ngày",month,year);
                else System.out.printf("Tháng %d năm %d có 28 ngày",month,year);
            }
            case 4,6,9,11 -> System.out.printf("Tháng %d năm %d có 30 ngày",month,year);
            default -> System.out.println("Khong hop le");
        }
    }
}
