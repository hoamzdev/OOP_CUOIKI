package Chuong2.IF_SWITCH;

import java.util.Scanner;

public class BAI1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();

        int D = a1 * b2 - a2 * b1;
        int Dy = a1 * c2 - a2 * c1;
        int Dx = c1 * b2 - c2 * b1;

        if(D != 0){
            System.out.printf("Phuong trinh co nghiem duy nhat :%.2f , %.2f",(double)Dx / D,(double)Dy / D);
        }
        else{
            //D == 0
            if(Dx == 0 && Dy == 0) System.out.println("Vo so nghiem");
            else System.out.println("Vo nghiem");
        }
    }
}
