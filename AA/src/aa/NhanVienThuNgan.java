/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa;

/**
 *
 * @author Admin
 */
public class NhanVienThuNgan extends NhanVien{
    private boolean isBietNgoaiNgu;

    public NhanVienThuNgan(String hoTen, float thamNien, String queQuan, float soGioLamViec, boolean isBietNgoaiNgu) {
        super(hoTen, thamNien, queQuan, soGioLamViec);
        this.isBietNgoaiNgu = isBietNgoaiNgu;
    }

    public boolean isIsBietNgoaiNgu() {
        return isBietNgoaiNgu;
    }

    public void setIsBietNgoaiNgu(boolean isBietNgoaiNgu) {
        this.isBietNgoaiNgu = isBietNgoaiNgu;
    }
    
    private String bietNgoaiNgu(boolean isBNN){
        if(isBNN) return "Biet ngoai ngu";
        return "Khong biet ngoai ngu";
    }

    @Override
    public String toString() {
        return super.toString() + "," + bietNgoaiNgu(this.isBietNgoaiNgu);
    }
    
    
    @Override
    public Object[] toObject() {
        return new Object[]{
            hoTen,
            String.format("%.1f nam",thamNien),
            queQuan,
            String.format("%.2f",soGioLamViec),
            isBietNgoaiNgu,
            String.format("%.2f", tinhLuong())
        };
    }
    
    
    
}
