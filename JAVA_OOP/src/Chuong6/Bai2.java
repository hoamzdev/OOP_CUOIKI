package Chuong6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class NhanVien implements Serializable {

    private String mnv;
    private String hoTen;
    private int age;
    private float luong;

    public NhanVien(String mnv, String hoTen, int age, float luong) {
        this.mnv = mnv;
        this.hoTen = hoTen;
        this.age = age;
        this.luong = luong;
    }

    @Override
    public String toString() {
        return mnv + "  " + hoTen + "  " + age + "  " + luong;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NhanVien other = (NhanVien) obj;
        if (this.age != other.age) {
            return false;
        }
        if (Float.floatToIntBits(this.luong) != Float.floatToIntBits(other.luong)) {
            return false;
        }
        if (!Objects.equals(this.mnv, other.mnv)) {
            return false;
        }
        return Objects.equals(this.hoTen, other.hoTen);
    }
}

public class Bai2 {

    private static final String filename = "nhanvien.bat";

    public static void main(String[] args) {
        List<NhanVien> listNhanVien = new ArrayList<>();
        listNhanVien.add(new NhanVien("CT08", "hoa", 12, 12345.6f));
        listNhanVien.add(new NhanVien("CT07", "hoa", 12, 12345.6f));
        listNhanVien.add(new NhanVien("CT09", "hoa", 12, 12345.6f));
        listNhanVien.add(new NhanVien("CT04", "hoa", 12, 12345.6f));
        listNhanVien.add(new NhanVien("CT03", "hoa", 12, 12345.6f));

//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
//            oos.writeObject(listNhanVien);
//        }catch(IOException e){
//            System.err.println("e");
//            e.printStackTrace();
//        }finally{
//            System.out.println("Finished");
//        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            ArrayList<NhanVien> list;
            try {
                list = (ArrayList<NhanVien>) ois.readObject();
                list.forEach(it ->{
                    System.out.println(it);
                });
            } catch (ClassNotFoundException ex) {
                System.getLogger(Bai2.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        } finally {
            System.out.println("Finished");
        }
    }
}
