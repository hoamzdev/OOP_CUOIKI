package e;

public class CanBo {
    protected String ten;
    protected String namSinh;
    protected String gioiTinh;
    protected String diaChi;
    protected double heSoLuong;
    public static int LUONG_CO_BAN = 2000000;

    public CanBo(String ten, String namSinh, String gioiTinh, String diaChi, double heSoLuong) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.heSoLuong = heSoLuong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(double heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong(){
        return heSoLuong * LUONG_CO_BAN;
    }

    @Override
    public String toString() {
        return ten + ", " + namSinh + ", " + gioiTinh + ", " + diaChi + ", " + "Luong: " + String.format("%.2f", tinhLuong());
    }
    
    public Object[] toObject(){
        return new Object[]{};
    }
}
