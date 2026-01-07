/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l;

/**
 *
 * @author Admin
 */
public class ThuNgan extends NhanVien{
    private boolean isBietNgoaiNgu;

    public ThuNgan(String hoTen, int thamNien, String queQuan, double soGioLamVc, boolean isBietNgoaiNgu) {
        super(hoTen, thamNien, queQuan, soGioLamVc);
        this.isBietNgoaiNgu = isBietNgoaiNgu;
    }

    public boolean isIsBietNgoaiNgu() {
        return isBietNgoaiNgu;
    }

    public void setIsBietNgoaiNgu(boolean isBietNgoaiNgu) {
        this.isBietNgoaiNgu = isBietNgoaiNgu;
    }

    private String bietNgoaiNgu(){
        if(isBietNgoaiNgu) return "Biet ngoai ngu";
        return "Khong biet ngoai ngu";
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + bietNgoaiNgu();
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{
            hoTen,
            String.format("%d", thamNien),
            queQuan,
            String.format("%.2f", soGioLamVc),
            bietNgoaiNgu(),
            String.format("%.2f", tinhLuong())
        };
    }
           
    
}
