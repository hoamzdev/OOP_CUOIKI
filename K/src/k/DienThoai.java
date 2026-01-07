/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package k;

/**
 *
 * @author Admin
 */
public class DienThoai extends HangHoa{
    private double giaSimGhep;
    public DienThoai(String ten, String ma, double giaNhap, double giaBan, double giaSimGhep) {
        super(ten, ma, giaNhap, giaBan);
        this.giaSimGhep = giaSimGhep;
    }

    public double getGiaSimGhep() {
        return giaSimGhep;
    }

    @Override
    public double tinhLoiNhuan() {
        return super.tinhLoiNhuan() - giaSimGhep;
    }
    
    
    public void setGiaSimGhep(double giaSimGhep) {
        this.giaSimGhep = giaSimGhep;
    }

    @Override
    public String toString() {
        return super.toString() + ", Gia sim ghep: " + giaSimGhep;
    }
}
