package b.Cau1;

import java.io.Serializable;

public class SinhVien implements Serializable{

    private String hoTen;
    private String maSv;
    private double diemHocPhan;
    private double diemQt;

    public SinhVien(String hoTen, String maSv, double diemHocPhan, double diemQt) {
        this.hoTen = hoTen;
        this.maSv = maSv;
        this.diemHocPhan = diemHocPhan;
        this.diemQt = diemQt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getMaSv() {
        return maSv;
    }

    public double getDiemHocPhan() {
        return diemHocPhan;
    }

    public double getDiemQt() {
        return diemQt;
    }

    public double tinhDiemTB() {
        return (diemQt * 0.3 + diemHocPhan * 0.7);
    }

    public void hinThiTT() {
        System.out.println(hoTen + ", " + maSv + ", " + diemQt + ", " + diemHocPhan + ", " + tinhDiemTB());
    }
    
    public Object[] toObject(){
        return new Object[]{maSv,hoTen,diemQt,diemHocPhan};
    }

}
