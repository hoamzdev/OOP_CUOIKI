/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb;

/**
 *
 * @author Admin
 */
public class SinhVien {
    protected String maSV;
    protected String hoTen;
    protected float diemTB;

    public SinhVien(String maSV, String hoTen, float diemTB) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return maSV + "," + hoTen + "," + String.format("%.2f", diemTB);
    }
    
    
    public void inTT(){
        System.out.println(this.toString());
    }
           
    public Object[] toObject(){
        return new Object[]{};
    }
    
}
