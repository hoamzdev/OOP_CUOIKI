package Chuong4.Abstract;

abstract class HinhHoc {
    private String tenHinh;
    private double chuVi,dienTich;

    public HinhHoc(String tenHinh){
        this.tenHinh = tenHinh;
    }

    public void inTenHinh(){
        System.out.println("Day la " + tenHinh);
    }

    abstract double tinhChuVi();
    abstract double tinhDienTich();
}


class HinhTron extends HinhHoc{

    private double radius;

    public HinhTron(String tenHinh,double radius){
        super(tenHinh);
        this.radius = radius;
    }

    @Override
    double tinhChuVi() {
        return 2 * Math.PI * radius;
    }

    @Override
    double tinhDienTich() {
        return Math.PI * radius * radius;
    }
}

class HinhChuNhat extends HinhHoc{

    private final double chieuDai,chieuRong;

    public HinhChuNhat(String tenHinh,double chieuDai,double chieuRong){
        super(tenHinh);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    @Override
    double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    @Override
    double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    @Override
    public void inTenHinh() {
        System.out.println("Day la phuong thuc in ten hinh cua hinh chu nhat");
    }
}


class HinhTamGiac extends HinhHoc{

    private final double a,b,c;

    public HinhTamGiac(String tenHinh,double a,double b,double c){
        super(tenHinh);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double tinhChuVi() {
        return a + b + c;
    }

    @Override
    double tinhDienTich() {
        double S = (a + b + c) / 2;
        return Math.sqrt(S * (S - a) * (S - b) * (S - c));
    }
}

public class Bai1 {
    public static void main(String[] args) {
        HinhHoc hh = new HinhChuNhat("Hinh Chu Nhar", 10, 20);
        System.out.println(hh.tinhChuVi() + " " + hh.tinhDienTich());
        hh.inTenHinh();
    }
}
