/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g;

/**
 *
 * @author Admin
 */
public class TaiKhoanTietKiem extends TaiKhoan{
    private double laiSuat;
    private String kiHan;

    public TaiKhoanTietKiem(String maTK, String tenChuTK, double soDu, double laiSuat, String kiHan) {
        super(maTK, tenChuTK, soDu);
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public String getKiHan() {
        return kiHan;
    }

    public void setKiHan(String kiHan) {
        this.kiHan = kiHan;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Lai suat: " + String.format("%.2f", laiSuat) + ", Ki han: " + kiHan;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            maTK,
            tenChuTK,
            String.format("%.2f", soDu),
            String.format("%.2f", laiSuat),
            kiHan
        };
    }
}
