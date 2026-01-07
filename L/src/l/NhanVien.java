package l;

public class NhanVien {

    protected String hoTen;
    protected int thamNien;
    protected String queQuan;
    protected double soGioLamVc;
    public static int LUONG_GIO = 100000;

    public NhanVien(String hoTen, int thamNien, String queQuan, double soGioLamVc) {
        this.hoTen = hoTen;
        this.thamNien = thamNien;
        this.queQuan = queQuan;
        this.soGioLamVc = soGioLamVc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getThamNien() {
        return thamNien;
    }

    public void setThamNien(int thamNien) {
        this.thamNien = thamNien;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public double getSoGioLamVc() {
        return soGioLamVc;
    }

    public void setSoGioLamVc(double soGioLamVc) {
        this.soGioLamVc = soGioLamVc;
    }

    public void inTT() {
        System.out.println(this.toString());
    }

    public double tinhLuong() {
        return soGioLamVc * LUONG_GIO;
    }

    @Override
    public String toString() {
        return hoTen + ", " + thamNien + " nam, " + queQuan + ", " + soGioLamVc + ", " + String.format("%.2f", tinhLuong());
    }

    public Object[] toObject() {
        return new Object[]{};
    }

}
