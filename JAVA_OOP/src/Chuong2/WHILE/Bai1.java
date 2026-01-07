package Chuong2.WHILE;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n: ");
        int n = sc.nextInt();
        int []a = new int[n];
        System.out.print("Nhap mang a : ");
        for(int i=0;i<n;i++) a[i] = sc.nextInt();

        System.out.print("Nhap m: ");
        int m = sc.nextInt();
        int []b = new int[m];
        System.out.print("Nhap mang b : ");
        for(int j=0;j<m;j++) b[j] = sc.nextInt();

        int []c = new int[n + m + 1];
        int i = 0,j = 0,k = 0;

        while(i < n && j < m){
            if(a[i] < b[j]) c[k++] = a[i++];
            else c[k++] = b[j++];
        }

        while(i < n) c[k++] = a[i++];
        while(j < m) c[k++] = b[j++];

        for(int x  = 0;x < n + m;x++) System.out.print(c[x] + " ");
    }
}
