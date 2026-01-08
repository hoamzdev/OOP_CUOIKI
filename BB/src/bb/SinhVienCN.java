/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bb;

/**
 *
 * @author Admin
 */
public class SinhVienCN extends SinhVien{
    private String nganhHoc;
    private int namNhapHoc;

    public SinhVienCN(String maSV, String hoTen, float diemTB, String nganhHoc, int namNhapHoc) {
        super(maSV, hoTen, diemTB);
        this.nganhHoc = nganhHoc;
        this.namNhapHoc = namNhapHoc;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    @Override
    public String toString() {
        return super.toString() + "," + nganhHoc + "," + namNhapHoc;
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            maSV,
            hoTen,
            String.format("%.2f", diemTB),
            nganhHoc,
            namNhapHoc
        };
    }

    
    
}