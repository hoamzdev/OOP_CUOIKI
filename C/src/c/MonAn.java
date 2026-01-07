package c;

public class MonAn extends MatHang {

    private boolean isCanTrinhDien;

    public MonAn(String maHang, String tenMatHang, int soLuong, double giaVon, boolean isCanTrinhDien) {
        super(maHang, tenMatHang, soLuong, giaVon);
        this.isCanTrinhDien = isCanTrinhDien;
    }

    public boolean isIsCanTrinhDien() {
        return isCanTrinhDien;
    }

    public void setIsCanTrinhDien(boolean isCanTrinhDien) {
        this.isCanTrinhDien = isCanTrinhDien;
    }

    @Override
    public double tinhGiaTrenMenu() {
        if (isCanTrinhDien) {
            return super.tinhGiaTrenMenu() + 200000;
        }
        return super.tinhGiaTrenMenu();
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println(" Can trinh dien: " + isCanTrinhDien);
    }

    @Override
    public String cvGiaTienMenu() {
        return String.format("%.2f", tinhGiaTrenMenu());
    }

    
    
    @Override
    public Object[] toObject(){
        return new Object[]{maHang,tenMatHang,soLuong,cvGiaTienMenu()};
    }
    
}
