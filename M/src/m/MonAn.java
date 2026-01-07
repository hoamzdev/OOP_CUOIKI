/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m;

/**
 *
 * @author Admin
 */
public class MonAn extends MatHang{
    private boolean isCanTrinhDien;

    public MonAn(String maMH, String tenHang, int soLuong, double giaVon, boolean isCanTrinhDien) {
        super(maMH, tenHang, soLuong, giaVon);
        this.isCanTrinhDien = isCanTrinhDien;
    }

    public boolean isIsCanTrinhDien() {
        return isCanTrinhDien;
    }

    public void setIsCanTrinhDien(boolean isCanTrinhDien) {
        this.isCanTrinhDien = isCanTrinhDien;
    }

    @Override
    public double tinhGiaTrenMenu() {
        return super.tinhGiaTrenMenu() + ((isCanTrinhDien) ? 200000 : 0);
    }
    
    
    private String trinhDien(){
        if(isCanTrinhDien) return "Can trinh dien";
        return "Khong can trinh dien";
    }

    @Override
    public String toString() {
        return super.toString() + "," + trinhDien();
    }
    
    
    
}
