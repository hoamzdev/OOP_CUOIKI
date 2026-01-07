/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j;

/**
 *
 * @author Admin
 */
public class NhanVien extends CanBo{
    private String nganhDaoTao;

    public NhanVien(String ten, String namSinh, String gioiTinh, String diaChi, double heSoLuong, String ndt) {
        super(ten, namSinh, gioiTinh, diaChi, heSoLuong);
        this.nganhDaoTao = ndt;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + nganhDaoTao;
    }
    
    public Object[] toObject(){
        return new Object[]{
            ten,
            namSinh,
            gioiTinh,
            diaChi,
            heSoLuong,
            nganhDaoTao,
            String.format("%.2f", tinhLuong())
        };
    }
    
}
