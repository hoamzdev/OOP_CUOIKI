
package bb;

public class SinhVienTD extends SinhVien{
    private String truongTraoDoi;
    private int thoiGianTraoDoi;

    public SinhVienTD(String maSV, String hoTen, float diemTB, String truongTraoDoi, int thoiGianTraoDoi) {
        super(maSV, hoTen, diemTB);
        this.truongTraoDoi = truongTraoDoi;
        this.thoiGianTraoDoi = thoiGianTraoDoi;
    }

    public String getTruongTraoDoi() {
        return truongTraoDoi;
    }

    public void setTruongTraoDoi(String truongTraoDoi) {
        this.truongTraoDoi = truongTraoDoi;
    }

    public int getThoiGianTraoDoi() {
        return thoiGianTraoDoi;
    }

    public void setThoiGianTraoDoi(int thoiGianTraoDoi) {
        this.thoiGianTraoDoi = thoiGianTraoDoi;
    }

    @Override
    public String toString() {
        return super.toString() + "," + truongTraoDoi + "," + thoiGianTraoDoi + " tháng";
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{
            maSV,
            hoTen,
            String.format("%.2f", diemTB),
            truongTraoDoi,
            thoiGianTraoDoi
        };
    }
    
    
}
