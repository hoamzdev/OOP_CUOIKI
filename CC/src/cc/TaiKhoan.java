/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cc;


public class TaiKhoan {
    protected String maTK;
    protected String tenTK;
    protected double soDu;

    public TaiKhoan(String maTK, String tenTK, double soDu) {
        this.maTK = maTK;
        this.tenTK = tenTK;
        this.soDu = soDu;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenTK() {
        return tenTK;
    }

    public void setTenTK(String tenTK) {
        this.tenTK = tenTK;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    @Override
    public String toString() {
        return maTK + "," + tenTK + "," + String.format("%.2f", soDu);
    }
    
    public void inTT(){
        System.out.println(this.toString());
    }
}
