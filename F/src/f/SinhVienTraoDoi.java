/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f;

public class SinhVienTraoDoi extends SinhVien{
    private String truongTraoDoi;
    private String thoiGianTraoDoi;

    public SinhVienTraoDoi(String maSv, String hoTen, double diemTrungBinhh, String trongTraoDoi, String thoiGian) {
        super(maSv, hoTen, diemTrungBinhh);
        this.truongTraoDoi = trongTraoDoi;
        this.thoiGianTraoDoi = thoiGian;
    }

    public String getTruongTraoDoi() {
        return truongTraoDoi;
    }

    public void setTruongTraoDoi(String truongTraoDoi) {
        this.truongTraoDoi = truongTraoDoi;
    }

    public String getThoiGianTraoDoi() {
        return thoiGianTraoDoi;
    }

    public void setThoiGianTraoDoi(String thoiGianTraoDoi) {
        this.thoiGianTraoDoi = thoiGianTraoDoi;
    }

    @Override
    public String toString() {
        return super.toString() + ", Truong trao doi: " + truongTraoDoi + ", Thoi gian trao doi: " + thoiGianTraoDoi;
    }
    
    public Object[] toObject(){
        return new Object[]{
            getMaSv(),
            getHoTen(),
            String.format("%.2f", getDiemTrungBinhh()),
            truongTraoDoi,
            thoiGianTraoDoi
        };
    }
    
}
