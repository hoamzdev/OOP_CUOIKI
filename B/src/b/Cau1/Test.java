/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b.Cau1;
/**
 *
 * @author hwa
 */
public class Test {
    public static void main(String[] args) {
        LopHoc L01 = new LopHoc(70, "L01 - OOP");
        //fake sinh vien
        SinhVien sv1 = new SinhVien("DVH", "CT080221", 9.0F, 10);
        SinhVien sv2 = new SinhVien("DH", "CT080221", 9.0F, 10);
        SinhVien sv3 = new SinhVien("VH", "CT080221", 9.0F, 10);
        SinhVien sv4 = new SinhVien("DV", "CT080221", 9.0F, 10);
        SinhVien sv5 = new SinhVien("VH", "CT080221", 9.0F, 10);
        
        L01.addSinhVien(sv1);
        L01.addSinhVien(sv2);
        L01.addSinhVien(sv3);
        L01.addSinhVien(sv4);
        L01.addSinhVien(sv5);
        
        L01.showDsLop();
        
    }
}
