package c;

public class DoUong extends MatHang {

    private boolean isCoNongHayKhong;

    public DoUong(String maHang, String tenMatHang, int soLuong, double giaVon, boolean isCoNongHayKhong) {
        super(maHang, tenMatHang, soLuong, giaVon);
        this.isCoNongHayKhong = isCoNongHayKhong;
    }

    public boolean isIsCoNongHayKhong() {
        return isCoNongHayKhong;
    }

    public void setIsCoNongHayKhong(boolean isCoNongHayKhong) {
        this.isCoNongHayKhong = isCoNongHayKhong;
    }

    @Override
    public void inThongTin() {
        super.inThongTin();
        System.out.println(" Co nong hay khong: " + isCoNongHayKhong);
    }
    
    
    @Override
    public Object[] toObject(){
        return new Object[]{maHang,tenMatHang,soLuong,cvGiaTienMenu()};
    }

}
