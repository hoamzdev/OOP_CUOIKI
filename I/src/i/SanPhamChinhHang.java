/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i;

/**
 *
 * @author Admin
 */
public class SanPhamChinhHang extends SanPham{
    private String nhaSanXuat;
    private int soThangBaoHanh;

    public SanPhamChinhHang(String maSP, String tenSP, double giaBan, String nhaSanXuat, int soThangBaoHanh) {
        super(maSP, tenSP, giaBan);
        this.nhaSanXuat = nhaSanXuat;
        this.soThangBaoHanh = soThangBaoHanh;
    }

    public int getSoThangBaoHanh() {
        return soThangBaoHanh;
    }

    public void setSoThangBaoHanh(int soThangBaoHanh) {
        this.soThangBaoHanh = soThangBaoHanh;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nha sx: " + nhaSanXuat + ", So thang bao hanh: " + soThangBaoHanh;
    }
}
