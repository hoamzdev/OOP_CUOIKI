/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l;

/**
 *
 * @author Admin
 */
public class NhanVienBep extends NhanVien{
    private boolean  isBepTruong;
    private double thuongChucVu;

    public NhanVienBep(String hoTen, int thamNien, String queQuan, double soGioLamVc,boolean  isBepTruong,double thuongChucVu ) {
        super(hoTen, thamNien, queQuan, soGioLamVc);
        this.isBepTruong = isBepTruong;
        this.thuongChucVu = thuongChucVu;
    }

    public double getThuongChucVu() {
        return thuongChucVu;
    }

    public void setThuongChucVu(double thuongChucVu) {
        this.thuongChucVu = thuongChucVu;
    }

    public boolean isIsBepTruong() {
        return isBepTruong;
    }

    public void setIsBepTruong(boolean isBepTruong) {
        this.isBepTruong = isBepTruong;
    }
    
    private String bepTruong(){
        if(isBepTruong) return "Bep truong";
        return "Nhan vien bep";
    }

    @Override
    public String toString() {
        return super.toString() + ", " + bepTruong() + ", " + String.format("%.2f", thuongChucVu);
    }

    @Override
    public Object[] toObject() {
        return new Object[]{
            hoTen,
            String.format("%d", thamNien),
            queQuan,
            String.format("%.2f", soGioLamVc),
            bepTruong(),
            String.format("%.2f", thuongChucVu),
            String.format("%.2f", tinhLuong())
        };
    }
    
    
    
}
