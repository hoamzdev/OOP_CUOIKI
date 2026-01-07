package Chuong2;

import java.util.Scanner;

public class GiaiPTBac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a,b,c;
        System.out.print("Nhap a : ");a = sc.nextDouble();
        System.out.print("Nhap b : ");b = sc.nextDouble();
        System.out.print("Nhap c : ");c = sc.nextDouble();
        //case 1: a = 0
        if(a == 0){
            double res = -c / b;
            System.out.printf("Phuong trinh co nghiem la : %.2f\n",res);
        }
        //case 2 : dud dang pt bac 2
        else{
            //tinh denta
            double denta = b * b - 4 * a * c;
            if(denta < 0) System.out.println("Phuong trinh vo nghiem");
            else if(denta == 0){
                double res = -b / 2 * a;
                System.out.printf("Phuong trinh co nghiem kep : %.2f\n",res);
            }
            else {
                double x1 = (-b - Math.sqrt(denta)) / 2 * a;
                double x2 = (-b + Math.sqrt(denta)) / 2 * a;
                System.out.printf("Phuong trinh co hai nghiem phan biet : %.2f va %.2f\n",x1,x2);
            }
        }
    }
}
