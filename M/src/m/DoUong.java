/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package m;


public class DoUong extends MatHang {

    private boolean isHot;

    public DoUong(String maMH, String tenHang, int soLuong, double giaVon, boolean isHot) {
        super(maMH, tenHang, soLuong, giaVon);
        this.isHot = isHot;
    }

    public boolean isIsHot() {
        return isHot;
    }

    public void setIsHot(boolean isHot) {
        this.isHot = isHot;
    }

    private String hot(){
        if(isHot) return "Co nong";
        return "Khong nong";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + hot();
    }
}
