
package g;


public class TaiKhoan {
    protected String maTK;
    protected String tenChuTK;
    protected double soDu;

    public TaiKhoan(String maTK, String tenChuTK, double soDu) {
        this.maTK = maTK;
        this.tenChuTK = tenChuTK;
        this.soDu = soDu;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenChuTK() {
        return tenChuTK;
    }

    public void setTenChuTK(String tenChuTK) {
        this.tenChuTK = tenChuTK;
    }

    public double getSoDu() {
        return soDu;
    }

    public void setSoDu(double soDu) {
        this.soDu = soDu;
    }

    @Override
    public String toString() {
        return "Ma tai khoan: " +  maTK + ", Ten chu tai khoan: " + tenChuTK + ", So du: " + String.format("%.2f", soDu);
    }
    
    public void inThongTin(){
        System.out.println(this.toString());
    }
    
    public Object[] toObject(){
        return new Object[]{};
    }
}
