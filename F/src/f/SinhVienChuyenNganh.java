/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f;


public class SinhVienChuyenNganh extends SinhVien{
    private String nganhHoc;
    private int namNhapHoc;

    public SinhVienChuyenNganh(String maSv, String hoTen, double diemTrungBinhh, String nh, int namNhapHoc) {
        super(maSv, hoTen, diemTrungBinhh);
        this.nganhHoc = nh;
        this.namNhapHoc = namNhapHoc;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public int getNamNhapHoc() {
        return namNhapHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public void setNamNhapHoc(int namNhapHoc) {
        this.namNhapHoc = namNhapHoc;
    }

    @Override
    public String toString() {
        return super.toString() + ", Nganh hoc: " + nganhHoc + ", Nam nhap hoc: " + namNhapHoc;
    }

    public Object[] toObject(){
        return new Object[]{
            getMaSv(),
            getHoTen(),
            String.format("%.2f", getDiemTrungBinhh()),
            nganhHoc,
            namNhapHoc
        };
    }
    
}
