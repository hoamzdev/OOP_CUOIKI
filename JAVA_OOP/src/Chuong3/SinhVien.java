package Chuong3;

import java.util.Scanner;

public class SinhVien {
    private String maSo;
    private String hoTen;
    private float diemM1,diemM2,diemM3;

    //nhap tt sinh vien tu ban phim
    public void nhap(Scanner sc){
        System.out.print("Nhap ma so sinh vien : ");maSo = sc.next();
        sc.nextLine();
        System.out.print("Nhap ho ten sinh vien : ");hoTen = sc.nextLine();
        System.out.print("Nhap diem M1 : ");diemM1 = sc.nextFloat();
        System.out.print("Nhap diem M2 : ");diemM2 = sc.nextFloat();
        System.out.print("Nhap diem M3 : ");diemM3 = sc.nextFloat();
    }

    //hien thi thong tin sinh vienpub
    public void hienThi(){
        System.out.print(maSo + " " + hoTen + " " + diemM1 + " " + diemM2 + " " + diemM3 + " ");
        System.out.printf("%.2f\n",tinhDiemTrungBinh());
    }

    //tinh diem tb 3 mon
    public float tinhDiemTrungBinh(){
        return (diemM1 + diemM2 + diemM3) / 3;
    }

    public String xepLoai(){
        if(tinhDiemTrungBinh() >= 8.0) return "Gioi";
        else if(tinhDiemTrungBinh() >= 6.5) return "Kha";
        else if(tinhDiemTrungBinh() >= 5.0) return "Trung Binh";
        return "Yeu";
    }
}
