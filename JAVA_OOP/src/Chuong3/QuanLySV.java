package Chuong3;

class SinhVien1{
    public static int soLuongSV = 0;//dem sl sv hien co
    private String maSV;
    private String ten;
    private float diem;

    public SinhVien1(String maSV, String ten, float diem) {
        this.maSV = maSV;
        this.ten = ten;
        this.diem = diem;
        soLuongSV++;
    }

    public float getDiem() {
        return diem;
    }

    public void hienThi(){
        System.out.println(maSV + "  " + ten + "  " + diem);
    }
}

public class QuanLySV {
    private static SinhVien1[] sv;
    public static final int MAX_SV = 100;
    public static int index = 0;

    public QuanLySV(){
        sv = new SinhVien1[MAX_SV];
    }
    //them sinh vien
    public void themSinhVien(SinhVien1 svien){
        sv[index++] = svien;
    }

    //tinh diem trinh binh cua tat ca cac sv
    public static float tinhDiemTrungBinh(){
        float tongDiem = 0;
        for(int i=0;i<SinhVien1.soLuongSV;i++){
            tongDiem += sv[i].getDiem();
        }
        return tongDiem / SinhVien1.soLuongSV;
    }

    //tim va hien thi sv co diem cao nhat
    public void tim_SVMAX(){
        float diemMax = 0;
        for(int i=0;i<SinhVien1.soLuongSV;i++){
            if(sv[i].getDiem() > diemMax){
                diemMax = sv[i].getDiem();
            }
        }
        for(int i=0;i<SinhVien1.soLuongSV;i++){
            if(sv[i].getDiem() == diemMax){
                sv[i].hienThi();
            }
        }
    }

    //hien thi ds sinh vien
    public static void hienThiTatCaSinhVien(){
        for(int i=0;i<SinhVien1.soLuongSV;i++) sv[i].hienThi();
    }

    //test
    public static void main(String[] args) {
        SinhVien1 svA = new SinhVien1("CT01","HOA",9.5F);
        SinhVien1 svB = new SinhVien1("CT08","AOH",9F);
        SinhVien1 svC = new SinhVien1("CT08","OAH",9.5F);

        QuanLySV qlsv = new QuanLySV();
        qlsv.themSinhVien(svA);
        qlsv.themSinhVien(svB);
        qlsv.themSinhVien(svC);

        System.out.println(SinhVien1.soLuongSV);

//        QuanLySV.hienThiTatCaSinhVien();

        qlsv.tim_SVMAX();
    }
}
