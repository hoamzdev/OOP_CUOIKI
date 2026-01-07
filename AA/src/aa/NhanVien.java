/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa;

/**
 *
 * @author Admin
 */
public class NhanVien {
    protected String hoTen;
    protected float thamNien;
    protected String queQuan;
    protected float soGioLamViec;
    public static final int LUONG_GIO = 100000;

    public NhanVien(String hoTen, float thamNien, String queQuan, float soGioLamViec) {
        this.hoTen = hoTen;
        this.thamNien = thamNien;
        this.queQuan = queQuan;
        this.soGioLamViec = soGioLamViec;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getThamNien() {
        return thamNien;
    }

    public void setThamNien(float thamNien) {
        this.thamNien = thamNien;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public float getSoGioLamViec() {
        return soGioLamViec;
    }

    public void setSoGioLamViec(float soGioLamViec) {
        this.soGioLamViec = soGioLamViec;
    }
    
    public double tinhLuong(){
        return soGioLamViec * LUONG_GIO;
    }

    @Override
    public String toString() {
        return hoTen + "," + thamNien + "," + queQuan + "," + soGioLamViec + "," + String.format("%.2f", tinhLuong());
    }
    
    
    public void inTT(){
        System.out.println(this.toString());
    }
          
    public Object[] toObject(){
        return new Object[]{};
    }
    
}
