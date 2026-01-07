/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d;

public class Ruong {
    protected String maRuong;
    protected String tenChuHo;
    protected String loaiCayTrong;
    public static int DIEN_TICH_MAX = 100;

    public Ruong(String maRuong, String tenChuHo, String loaiCayTrong) {
        this.maRuong = maRuong;
        this.tenChuHo = tenChuHo;
        this.loaiCayTrong = loaiCayTrong;
    }

    public String getMaRuong() {
        return maRuong;
    }

    public String getTenChuHo() {
        return tenChuHo;
    }

    public String getLoaiCayTrong() {
        return loaiCayTrong;
    }

    public void setMaRuong(String maRuong) {
        this.maRuong = maRuong;
    }

    public void setTenChuHo(String tenChuHo) {
        this.tenChuHo = tenChuHo;
    }

    public void setLoaiCayTrong(String loaiCayTrong) {
        this.loaiCayTrong = loaiCayTrong;
    }
    
    public double tinhDienTich(){
        return 0;
    }
    
    public void inThongTin(){
        System.out.println(maRuong + ", " + tenChuHo + ", " + loaiCayTrong + ", " + tinhDienTich());
    }
    
    public Object[] toObject(){
        return new Object[]{};
    }  
}
