package Chuong2.FOR;

import java.util.Scanner;

public class Bai2 {

    private static void heap(int[] a, int n, int i) {
        int larget = i;
        int l = 2 * i + 1;//con trai
        int r = 2 * i + 2;//con phai
        if (l < n && a[larget] < a[l]) {
            larget = l;
        }
        if (r < n && a[larget] < a[r]) {
            larget = r;
        }
        //vun dong
        if (larget != i) {
            int tmp = a[larget];
            a[larget] = a[i];
            a[i] = tmp;
            heap(a, n, larget);//vun dong tiep tuc tu larget
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //vun dong tu dau
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(a, n, i);
        }

        //hoan doi phan tu dau tien so vs phan tu cuoi cung r loai bo phan tu cuoi cung do ra khoi dong
        //vun dong lai
        for (int i = n - 1; i >= 0; i--) {
            int tmp = a[i];
            a[i] = a[0];
            a[0] = tmp;
            heap(a, i, 0);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
