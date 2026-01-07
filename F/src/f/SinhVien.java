/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f;


public class SinhVien {
    private String maSv;
    private String hoTen;
    private double diemTrungBinhh;

    public SinhVien(String maSv, String hoTen, double diemTrungBinhh) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.diemTrungBinhh = diemTrungBinhh;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getDiemTrungBinhh() {
        return diemTrungBinhh;
    }

    public void setDiemTrungBinhh(double diemTrungBinhh) {
        this.diemTrungBinhh = diemTrungBinhh;
    }

    @Override
    public String toString() {
        return "MaSv: " + maSv + ", Ho ten: " + hoTen + ", Diem TB: " + String.format("%.2f", diemTrungBinhh);
    }
    
    public void inThongTin(){
        System.out.println(this.toString());
    }
    
    public Object[] toObject(){
        return new Object[]{};
    }
    
}
