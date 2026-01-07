/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j;


public class QuanLy extends CanBo{
    private double heSoCV;

    public QuanLy(String ten, String namSinh, String gioiTinh, String diaChi, double heSoLuong, double  heSoCv) {
        super(ten, namSinh, gioiTinh, diaChi, heSoLuong);
        this.heSoCV = heSoCv;
    }

    public double getHeSoCV() {
        return heSoCV;
    }

    public void setHeSoCV(double heSoCV) {
        this.heSoCV = heSoCV;
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() * (1 + heSoCV);
    }
    

    @Override
    public String toString() {
        return super.toString() + ", " + String.format("%.2f", heSoCV);
    }
    
    public Object[] toObject(){
        return new Object[]{
            ten,
            namSinh,
            gioiTinh,
            diaChi,
            heSoLuong,
            String.format("%.2f", heSoCV),
            String.format("%.2f", tinhLuong())
        };
    }
    
}
