/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dd;

/**
 *
 * @author Admin
 */
public class SanPhamChinhHang extends SanPham{
    private String nhaSanXuat;
    private int baoHanh;

    public SanPhamChinhHang(String maSP, String tenSP, double giaBan, String nhaSanXuat, int baoHanh) {
        super(maSP, tenSP, giaBan);
        this.nhaSanXuat = nhaSanXuat;
        this.baoHanh = baoHanh;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public void setBaoHanh(int baoHanh) {
        this.baoHanh = baoHanh;
    }

    @Override
    public String toString() {
        return super.toString() + ",Nhà sản xuất: " + nhaSanXuat + ",Bảo hành: " + baoHanh + " month";
    }
    
    
}
