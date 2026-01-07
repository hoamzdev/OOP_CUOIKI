package Chuong2.FOR;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang : ");
        int n = sc.nextInt() + 1;
        System.out.print("Nhap mang : ");
        int []a = new int[n];
        for(int i=0;i<n;i++) a[i] = sc.nextInt();
        System.out.print("Nhap gia tri x : ");
        int x = sc.nextInt();

        int res = 0;
        for(int i = 0;i<=n-1;i++){
            res += (int) (a[i] * Math.pow(x,i));
            if(a[i] == 0) continue;
            if(a[i] > 0 && i != 0) System.out.print("+");
            if(i == 0) System.out.print(a[i]);
            else if(i == 1) System.out.print(a[i] + "x");
            else System.out.print(a[i] + "x" + i);
        }
        System.out.println();
        System.out.println(res);
    }
}
