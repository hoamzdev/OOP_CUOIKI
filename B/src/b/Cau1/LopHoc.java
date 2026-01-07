package b.Cau1;

import java.util.ArrayList;
import java.util.List;

public class LopHoc {
    private List<SinhVien> list;
    private int siSo;
    private String tenLop;

    public LopHoc(int siSo, String tenLop) {
        this.siSo = siSo;
        this.tenLop = tenLop;
        list = new ArrayList<>();
    }
    
    public void addSinhVien(SinhVien sv){
        if(list.size() < siSo){
            list.add(sv);
            System.out.println("Them sv thanh cong");
        }
    }

    public String getTenLop() {
        return tenLop;
    }

    public List<SinhVien> getListSV() {
        return list;
    }

    //hien thi ds sinh vien
    public void showDsLop(){
        list.forEach((sv) -> {
            sv.hinThiTT();
        });
    }
    
}
