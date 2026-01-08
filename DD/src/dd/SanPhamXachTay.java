/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dd;

/**
 *
 * @author Admin
 */
public class SanPhamXachTay extends SanPham{
    private String nguonGoc;
    private String tinhTrang;

    public SanPhamXachTay(String maSP, String tenSP, double giaBan, String nguonGoc, String tinhTrang) {
        super(maSP, tenSP, giaBan);
        this.nguonGoc = nguonGoc;
        this.tinhTrang = tinhTrang;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return super.toString() + ",Nguồn gốc: " + nguonGoc + ",Tình trạng: " + tinhTrang;
    }
}
