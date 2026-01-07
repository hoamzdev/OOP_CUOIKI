/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j;

/**
 *
 * @author Admin
 */
public class CanBo {
    protected String ten;
    protected String namSinh;
    protected String gioiTinh;
    protected String diaChi;
    protected double heSoLuong;
    public static int LCB = 2000000;

    public CanBo(String ten, String namSinh, String gioiTinh, String diaChi, double heSoLuong) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.heSoLuong = heSoLuong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public static int getLCB() {
        return LCB;
    }

    public static void setLCB(int LCB) {
        CanBo.LCB = LCB;
    }

    public double tinhLuong(){
        return heSoLuong * LCB;
    }
    
    @Override
    public String toString() {
        return ten + ", " + namSinh + ", " + diaChi + ", " + gioiTinh + ", " + String.format("%.2f, ", heSoLuong) + tinhLuong();
    }
    
    public void inTT(){
        System.out.println(toString());
    }
    
    
    public Object[] toObject(){
        return new Object[]{};
    }
    
    
}
