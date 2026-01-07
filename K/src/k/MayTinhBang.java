/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package k;

/**
 *
 * @author Admin
 */
public class MayTinhBang extends HangHoa{
    private double kichThuocManHinh;

    public MayTinhBang(String ten, String ma, double giaNhap, double giaBan, double kichThuocManHinh) {
        super(ten, ma, giaNhap, giaBan);
        this.kichThuocManHinh = kichThuocManHinh;
    }

    public double getKichThuocManHinh() {
        return kichThuocManHinh;
    }

    public void setKichThuocManHinh(double kichThuocManHinh) {
        this.kichThuocManHinh = kichThuocManHinh;
    }

    @Override
    public String toString() {
        return super.toString() + ", Kich thuoc man hinh: " + kichThuocManHinh;
    }
}
