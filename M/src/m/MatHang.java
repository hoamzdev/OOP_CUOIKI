/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m;

/**
 *
 * @author Admin
 */
public class MatHang {
    protected String maMH;
    protected String tenHang;
    protected int soLuong;
    protected double giaVon;
    
    public static final double TY_LE_GIA_VON = 0.4;

    public MatHang(String maMH, String tenHang, int soLuong, double giaVon) {
        this.maMH = maMH;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.giaVon = giaVon;
    }

    public String getMaMH() {
        return maMH;
    }

    public void setMaMH(String maMH) {
        this.maMH = maMH;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(double giaVon) {
        this.giaVon = giaVon;
    }
    
    public double tinhGiaTrenMenu(){
        return giaVon / TY_LE_GIA_VON;
    }

    @Override
    public String toString() {
        return "Ma: " + maMH + ", Ten: " + tenHang + ", " + "So luong: "  + soLuong + ", Gia von: " + String.format("%.2f", giaVon) + ", Gia tren menu: " + String.format("%.2f", tinhGiaTrenMenu());
    }
    
    public void inTT(){
        System.out.println(this.toString());
    }
}
