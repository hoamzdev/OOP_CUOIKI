package c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C {

    public static void main(String[] args) {
        List<MatHang> matHangs = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("mathang.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                if(!line.isEmpty()){
                    String []mh = line.split(",");
                    String type = mh[0];
                    String maHang = mh[1];
                    String ten = mh[2];
                    int soLuong = Integer.parseInt(mh[3]);
                    double giaTien = Double.parseDouble(mh[4]);
                    if("1".equals(type)){
                        String td = mh[5];
                        boolean isTrinhDien = false;
                        if("true".equals(td)){
                            isTrinhDien = true;
                        }
                        matHangs.add(new MonAn(maHang,ten,soLuong,giaTien,isTrinhDien));
                    }
                    else{
                        String tt = mh[5];
                        boolean isCoNong = false;
                        if("true".equals(tt)){
                            isCoNong = true;
                        }
                        matHangs.add(new DoUong(maHang,ten,soLuong,giaTien,isCoNong));
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e);
        }
        
        if(matHangs.isEmpty()){
            System.out.println("Something wrong");
        }
        else{
            matHangs.forEach((mh) -> {
                mh.inThongTin();
            });
        }
        
    }

}
