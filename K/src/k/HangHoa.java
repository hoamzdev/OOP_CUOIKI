/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package k;

/**
 *
 * @author Admin
 */
public class HangHoa {
    protected String ten;
    protected String ma;
    protected double giaNhap;
    protected double giaBan;
    protected final double THUONG_BAN_HANG = 0.2;

    public HangHoa(String ma, String ten, double giaBan, double giaNhap) {
        this.ten = ten;
        this.ma = ma;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    
    public double tinhLoiNhuan(){
        return (giaBan - giaNhap) * (1 - THUONG_BAN_HANG);
    }

    @Override
    public String toString() {
        return "Ma: " + ma + ", Ho ten: " + ten + ", Gia ban: " + String.format("%.2f", giaBan) + ", Gia nhap: " + String.format("%.2f", giaNhap) + ", Loi nhuan:" + String.format("%.2f", tinhLoiNhuan());
    }
        
    public void inTT(){
        System.out.println(this.toString());
    }
    
}
