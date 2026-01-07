package Chuong2.FOR;


import java.util.Scanner;

public class Bai1 {
    private static int gt(int n){
        if(n == 0 || n == 1) return 1;
        return n * gt(n - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double res = 1f;
        for(int i=2;i<=n;i++){
            res += 1.0 / gt(i);
        }
        System.out.println(res);
    }
}
