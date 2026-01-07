/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa;

/**
 *
 * @author Admin
 */
public class NhanVienBep extends NhanVien{
    private boolean isBepTruong;
    private double thuongChucVu;

    public NhanVienBep(String hoTen, float thamNien, String queQuan, float soGioLamViec,boolean isBepTruong,double thuongChucVu) {
        super(hoTen, thamNien, queQuan, soGioLamViec);
        this.isBepTruong = isBepTruong;
        this.thuongChucVu = thuongChucVu;
    }

    public boolean isIsBepTruong() {
        return isBepTruong;
    }

    public void setIsBepTruong(boolean isBepTruong) {
        this.isBepTruong = isBepTruong;
    }

    public double getThuongChucVu() {
        return thuongChucVu;
    }

    public void setThuongChucVu(double thuongChucVu) {
        this.thuongChucVu = thuongChucVu;
    }

    private String bepTruong(boolean isBepTruong){
        if(isBepTruong) return "Bep truong";
        return "Nhan vien binh thuong";
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + ((isBepTruong) ? thuongChucVu : 0);
    }
    
    
    @Override
    public String toString() {
        return super.toString() + "," + bepTruong(this.isBepTruong);
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            hoTen,
            String.format("%.1f nam",thamNien),
            queQuan,
            String.format("%.2f",soGioLamViec),
            isBepTruong,
            String.format("%.2f", tinhLuong())
        };
    }
}
