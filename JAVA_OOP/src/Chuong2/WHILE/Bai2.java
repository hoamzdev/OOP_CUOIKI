package Chuong2.WHILE;

import java.util.Scanner;

public class Bai2 {
    public static int gt(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * gt(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //nhap eps
        float eps = sc.nextFloat();
        int n = 0;//start
        //nhap x
        float x = sc.nextFloat();
        double res = 0;
        do {
            boolean even = ((n % 2 == 0));
            double tmp = (even) ? 1.0 : -1.0;
            tmp *= Math.pow(x, 2 * n + 1);
            tmp /= (1.0 * gt(2 * n + 1));
            res += tmp;
            n++;
        } while (Math.abs(Math.pow(x, 2 * n + 1) / gt(2 * n + 1)) > eps);
        System.out.print(res);
    }
}
