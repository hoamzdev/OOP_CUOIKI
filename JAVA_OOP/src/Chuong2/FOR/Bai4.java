package Chuong2.FOR;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]a = new int[n][n];

        int v = 1;

        int c1 = 0,c2 = n - 1,h1 = 0,h2 = n - 1;

        while(c1 <= c2 && h1 <= h2){
            for(int i=c1;i<=c2;i++){
                a[h1][i] = v++;
            }
            h1++;
            for(int i = h1;i<=h2;i++){
                a[i][c2] = v++;
            }
            c2--;
            for(int i = c2;i>=c1;i--){
                a[h2][i] = v++;
            }
            h2--;
            for(int i = h2;i>=h1;i--){
                a[i][c1] = v++;
            }
            c1++;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
