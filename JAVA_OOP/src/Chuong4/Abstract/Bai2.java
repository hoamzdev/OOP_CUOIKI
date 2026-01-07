package Chuong4.Abstract;

/*
Tạo lớp Person (Người) với các thuộc tính: ten (String), tuoi (int), gioiTinh (boolean), diaChi (String).
- Tạo lớp Employee (Nhân viên) kế thừa từ Person, thêm các thuộc tính riêng như maNV (String), heSoLuong (double), luongCoBan (double).
- Tạo phương thức tinhLuong() trong lớp Employee để tính lương thực tế (luongCoBan * heSoLuong).
- Tạo một lớp Manager (Quản lý) kế thừa từ Employee và thêm một thuộc tính phuCap (double). Ghi đè phương thức tinhLuong() để cộng thêm phụ cấp vào lương.
- Viết chương trình để nhập thông tin và tính lương cho cả nhân viên và quản lý.

 */

import java.util.Scanner;

abstract class Person{
    protected String ten;
    protected int tuoi;
    protected boolean gioiTinh;
    protected String diaChi;

    public Person(String ten, int tuoi, boolean gioiTinh, String diaChi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    //tinh luong
    public abstract double tinhLuong();
}

class Employee extends Person{
    private String mNV;
    private double heSoLuong;
    private double luongCoBan;
    public Employee(String ten, int tuoi, boolean gioiTinh, String diaChi
            ,String mNV,double luongCoBan,double heSoLuong) {
        super(ten, tuoi, gioiTinh, diaChi);
        this.mNV = mNV;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    //tinh luong
    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong;
    }
}

class Manager extends Employee{
    private double phuCap;

    public Manager(String ten, int tuoi, boolean gioiTinh, String diaChi
            , String mNV, double luongCoBan, double heSoLuong,double phuCap) {
        super(ten, tuoi, gioiTinh, diaChi, mNV, luongCoBan, heSoLuong);
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + phuCap;
    }
}

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //hard code(dung sc de nhap thi hay hon)
        //nhan vien
        Person nv = new Employee("hoa",12,true,"Thai Binh","CT08",200000,1.5);
        System.out.println(nv.tinhLuong());
        //quan ly
        Person manager = new Manager("hoa",12,true,"Thai Binh","CT08",200000,1.5,500000);
        System.out.println(manager.tinhLuong());
    }
}
