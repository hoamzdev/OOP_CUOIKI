/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package e;


public class QuanLy extends CanBo{
    private double heSoChucVu;

    public QuanLy(String ten, String namSinh, String gioiTinh, String diaChi, double heSoLuong, double heSoChucVu) {
        super(ten, namSinh, gioiTinh, diaChi, heSoLuong);
        this.heSoChucVu = heSoChucVu;
    }

    public double getHeSoChucVu() {
        return heSoChucVu;
    }

    public void setHeSoChucVu(double heSoChucVu) {
        this.heSoChucVu = heSoChucVu;
    }

    @Override
    public String toString() {
        return super.toString() + " He so chuc vu :" + String.format("%.2f", heSoChucVu);
    }

    @Override
    public double tinhLuong() {
        return heSoLuong * LUONG_CO_BAN * (1 + heSoChucVu);
    }
    
    

    @Override
    public Object[] toObject() {
        return new Object[]{
            ten,
            namSinh,
            gioiTinh,
            diaChi,
            String.format("%.2f", heSoLuong),
            String.format("%.2f", heSoChucVu),
            String.format("%.2f", tinhLuong())
        };
    }
    
    
          
    
    
}
