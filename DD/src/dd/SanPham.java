/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dd;

/**
 *
 * @author Admin
 */
public class SanPham {
    protected String maSP;
    protected String tenSP;
    protected double giaBan;

    public SanPham(String maSP, String tenSP, double giaBan) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + maSP + ",Tên sản phẩm: " + tenSP + ",Giá bán: " + String.format("%.2f", giaBan);
    }
    
    public void inTT(){
        System.out.println(this.toString());
    }
    
}
