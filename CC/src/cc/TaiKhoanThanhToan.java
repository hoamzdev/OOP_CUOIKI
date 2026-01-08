
package cc;


public class TaiKhoanThanhToan extends TaiKhoan{
    private String loaiThe;
    private int soLuongGiaoDich;

    public TaiKhoanThanhToan(String maTK, String tenTK, double soDu, String loaiThe, int soLuongGiaoDich) {
        super(maTK, tenTK, soDu);
        this.loaiThe = loaiThe;
        this.soLuongGiaoDich = soLuongGiaoDich;
    }

    public String getLoaiThe() {
        return loaiThe;
    }

    public void setLoaiThe(String loaiThe) {
        this.loaiThe = loaiThe;
    }

    public int getSoLuongGiaoDich() {
        return soLuongGiaoDich;
    }

    public void setSoLuongGiaoDich(int soLuongGiaoDich) {
        this.soLuongGiaoDich = soLuongGiaoDich;
    }

    @Override
    public String toString() {
        return super.toString() + "," + loaiThe + "," + soLuongGiaoDich;
    }
}
