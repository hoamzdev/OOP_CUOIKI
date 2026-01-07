package Chuong3;

import java.util.Scanner;

public class PhanSo {
    private int a, b;//a tu,b mau

    public PhanSo(){}

    //cons
    private PhanSo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //nhap tu ban phim
    public void nhapPhanSo(Scanner sc) {
        System.out.print("Nhập tử số : ");
        a = sc.nextInt();
        System.out.print("Nhập mẫu số : ");
        b = sc.nextInt();
        if (b == 0) {
            while (b == 0) {
                System.out.print("Nhập lại mẫu số(Không được nhập bằng hong : ");
                b = sc.nextInt();
            }
        }
    }

    //tim UCLN cua tu va mau
    private int getUcln(PhanSo phanSo) {
        int _a = (phanSo.a > 0) ? phanSo.a : phanSo.a * -1;
        int _b = (phanSo.b > 0) ? phanSo.b : phanSo.b * -1;
        while (_b != 0) {
            int tmp = _b;
            _b = _a % _b;
            _a = tmp;
        }
        return _a;
    }

    //method rut gon phan so
    public PhanSo rutGon(PhanSo phanso) {
        int ucln = getUcln(phanso);
        return new PhanSo(phanso.a / ucln, phanso.b / ucln);
    }

    //cong hai phan so
    public PhanSo cong(PhanSo psB) {
        int tu = a * psB.b + b * psB.a;
        int mau = b * psB.b;
        PhanSo ps = new PhanSo(tu, mau);
        return rutGon(ps);
    }

    //tru hai phan so
    public PhanSo tru(PhanSo psB) {
        int tu = a * psB.b - b * psB.a;
        int mau = b * psB.b;
        PhanSo ps = new PhanSo(tu, mau);
        return rutGon(ps);
    }

    //nhan hai phan sp
    public PhanSo nhan(PhanSo psB) {
        int tu = a * psB.a;
        int mau = b * psB.b;
        PhanSo ps = new PhanSo(tu, mau);
        return rutGon(ps);
    }

    //chia hai phan so
    public PhanSo chia(PhanSo psB) {//A / B
        if (psB.a == 0) {
            System.out.println("Phép chia không hợp lệ");
            return null;
        }
        int tu = a * psB.b;
        int mau = b * psB.a;
        PhanSo ps = new PhanSo(tu, mau);
        return rutGon(ps);
    }

    //hien thi
    public void hienThi() {
        if (a == b) {
            System.out.println("1");
        } else if (a % b == 0) {
            System.out.println(a / b);
        } else {
            System.out.printf("%d / %d\n", a, b);
        }
    }
}
