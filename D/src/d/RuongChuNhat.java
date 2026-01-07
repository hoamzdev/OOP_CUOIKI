/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d;

public class RuongChuNhat extends Ruong {

    private double chieuDai, chieuRong;

    public RuongChuNhat(String maRuong, String tenChuHo, String loaiCayTrong, double chieuDai, double chieuRong) {
        super(maRuong, tenChuHo, loaiCayTrong);
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuDai(double chieuDai) {
        this.chieuDai = chieuDai;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    @Override
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            maRuong,
            tenChuHo,
            loaiCayTrong,
            String.format("%.2f", chieuDai),
            String.format("%.2f", chieuRong),
        };
    }

    @Override
    public String toString() {
        return maRuong + ", " + tenChuHo + ", " + loaiCayTrong + ", " + chieuDai + ", " + chieuRong + ", " + tinhDienTich();
    }

    
    
}
