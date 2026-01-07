
package c;

public abstract class MatHang {
    protected String tenMatHang;
    protected String maHang;
    protected int soLuong;
    protected double giaVon;
    public static double TY_LE_GIA_VON = 0.4F;

    public MatHang(String maHang, String tenMatHang, int soLuong, double giaVon) {
        this.tenMatHang = tenMatHang;
        this.maHang = maHang;
        this.soLuong = soLuong;
        this.giaVon = giaVon;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public void setTenMatHang(String tenMatHang) {
        this.tenMatHang = tenMatHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(double giaVon) {
        this.giaVon = giaVon;
    }
    
    
    
    public double tinhGiaTrenMenu(){
        return giaVon / TY_LE_GIA_VON;
    }
    
    public void inThongTin(){
        System.out.print(maHang + ", " + tenMatHang + ", " + soLuong + ", " + giaVon + ", ");
    }
    
    abstract public Object[] toObject();
    
    public String cvGiaTienMenu(){
        return String.format("%.2f", tinhGiaTrenMenu());
    }
    
}
