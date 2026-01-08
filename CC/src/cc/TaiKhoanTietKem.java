/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc;

/**
 *
 * @author Admin
 */
public class TaiKhoanTietKem extends TaiKhoan{
    private float laiSuat;
    private int kiHan;//tinh theo thang

    public TaiKhoanTietKem(String maTK, String tenTK, double soDu, float laiSuat, int kiHan) {
        super(maTK, tenTK, soDu);
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return super.toString() + "," + String.format("%.2f", laiSuat) + "," + kiHan;
    }
    
    
    
}
