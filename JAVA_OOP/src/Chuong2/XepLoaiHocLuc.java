package Chuong2;

import java.util.Scanner;

public class XepLoaiHocLuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int diem = sc.nextInt();

        //cach 1
        /*
        switch (diem){
            case 9: case 10:
                System.out.println("Gioi");
                break;
            case 8: case 7:
                System.out.println("Kha");
                break;
            case 5: case 6:
                System.out.println("Trung binh");
                break;
            default:
                System.out.println("Yes");
        }
         */
        //cach 2:
        /*
        switch (diem){
            case 9, 10:
                System.out.println("Gioi");
                break;
            case 8, 7:
                System.out.println("Kha");
                break;
            case 5, 6:
                System.out.println("Trung binh");
                break;
            default:
                System.out.println("Yes");
        }
         */
        //cach 3:
//        String res = switch (diem){
//            case 9,10 -> "Gioi";
//            case 8,7 -> "Kha";
//            case 6,5 -> "Trung binh";
//            default -> "Yeu";
//        };
//        System.out.println(res);
        //cach 4 -> ...
    }
}
