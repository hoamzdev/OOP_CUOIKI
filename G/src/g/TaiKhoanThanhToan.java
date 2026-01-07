/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g;

/**
 *
 * @author Admin
 */
public class TaiKhoanThanhToan extends TaiKhoan{
    private String loaiThe;
    private int soLuongGiaoDich;

    public TaiKhoanThanhToan(String maTK, String tenChuTK, double soDu,String loaiThe, int soLuongGD) {
        super(maTK, tenChuTK, soDu);
        this.loaiThe = loaiThe;
        this.soLuongGiaoDich = soLuongGD;
    }

    public int getSoLuongGiaoDich() {
        return soLuongGiaoDich;
    }

    public void setSoLuongGiaoDich(int soLuongGiaoDich) {
        this.soLuongGiaoDich = soLuongGiaoDich;
    }

    public String getLoaiThe() {
        return loaiThe;
    }

    public void setLoaiThe(String loaiThe) {
        this.loaiThe = loaiThe;
    }

    @Override
    public String toString() {
        return super.toString() + ", Loai the: " + loaiThe + ", So luong giao dich: " + soLuongGiaoDich;
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{
            maTK,
            tenChuTK,
            String.format("%.2f", soDu),
            loaiThe,
            soLuongGiaoDich    
        };
    }
    
}
