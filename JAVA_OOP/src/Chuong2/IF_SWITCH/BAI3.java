package Chuong2.IF_SWITCH;

import java.util.Scanner;

public class BAI3 {
    public static void main(String[] args) {
        //: vuông, vuông cân, cân, đều, tam giác thường
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean laTamGiac = ((a + b > c) && (b + c > a) && (c + a) > b);
        boolean vuong = ((a * a + b * b == c * c) || (a * a + c * c == b * b ) || (b * b + c * c) == a * a);
        boolean can = (a == b || b == c || c == a);
        boolean deu = (a == b && b == c);

        if(laTamGiac){
            if(deu) System.out.println("TG deu");
            else if(vuong && can) System.out.println("Vuong can");
            else if(vuong) System.out.println("Vuong");
            else if(can) System.out.println("Can");
            else System.out.println("TG bt");
        }
        else{
            System.out.println("Khong phai tam giac");
        }

    }
}
