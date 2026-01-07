/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d;


public class RuongVuong extends Ruong{
    private double doDaiCanh;

    public RuongVuong(String maRuong, String tenChuHo, String loaiCayTrong,double doDaiCanh) {
        super(maRuong, tenChuHo, loaiCayTrong);
        this.doDaiCanh = doDaiCanh;
    }

    public double getDoDaiCanh() {
        return doDaiCanh;
    }

    public void setDoDaiCanh(double doDaiCanh) {
        this.doDaiCanh = doDaiCanh;
    }

    @Override
    public double tinhDienTich() {
        return doDaiCanh * doDaiCanh;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            maRuong,
            tenChuHo,
            loaiCayTrong,
            String.format("%.2f", doDaiCanh),
            String.format("%.2f", doDaiCanh)
        };
    }
    
    @Override
    public String toString() {
        return maRuong + ", " + tenChuHo + ", " + loaiCayTrong + ", " + doDaiCanh + ", " + ", " + tinhDienTich();
    }

    
    
}
