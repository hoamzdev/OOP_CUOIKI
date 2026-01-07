package Chuong3;

import java.util.Scanner;

public class MaTranVuong {
    private int m, n;//m hang,n cot
    private int[][] a;

    public MaTranVuong() {
    }

    public void setA(int[][] a) {
        this.a = a;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setN(int n) {
        this.n = n;
    }

    //cons
    public MaTranVuong(int m, int n, int[][] a) {
        this.m = m;
        this.n = n;
        this.a = a;
    }

    //khao bao khoi tao ma tran
    public MaTranVuong(int m, int n) {
        this.m = m;
        this.n = n;
        a = new int[m][n];
    }

    //nhap ma tran
    public void nhap(Scanner sc) {
        System.out.print("Nhap so hang m = :");m = sc.nextInt();
        System.out.print("Nhap so hang n = :");n = sc.nextInt();
        a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    //cong ma tran
    public void cong(MaTranVuong b) {
        if (m != b.m || n != b.n) {
            System.out.println("Khong thực hiện được");
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    this.a[i][j] += b.a[i][j];
                }
            }
        }
    }

    //hien thi
    public void hienThi() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    //nhan hai ma tran
    public void nhan(MaTranVuong b) {
        MaTranVuong res = new MaTranVuong();
        if (n != b.m) {
            System.out.println("Khong thực hiện được");
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < b.n; j++) {
                    for (int k = 0; k < n; k++) {
                        res.a[i][j] += (this.a[i][k] * b.a[k][j]);
                    }
                }
            }
            setA(res.a);
            setM(res.m);
            setN(res.n);
        }
    }
}
