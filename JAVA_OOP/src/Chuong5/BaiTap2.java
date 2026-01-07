package Chuong5;

/*
Với bài xếp loại theo điểm thì phải kiểm tra điểm nhập vào không được nhỏ hơn 0 và lớn hơn 10
*/

class MarkException extends Exception{
    public MarkException(String msg){
        super(msg);
    }
}

class CheckDiem{
    public static void checkDiemValid(int mark) throws MarkException{
        try{
            if(mark < 0 || mark > 10){ 
                throw new MarkException("Diem khong hop le : " + mark);
            }
            System.out.println("Diem hop le");
        }catch(MarkException e){
            System.out.println("[LOG] Diem khong hop le " + mark);
            throw e;
        }
    }
    
    public static void markValid(int mark) throws MarkException{
        checkDiemValid(mark);
        System.out.println("Check diem thanh cong");
    }
}

public class BaiTap2 {
    public static void main(String[] args) {
        try {
            CheckDiem.markValid(-10);
        } catch (MarkException ex) {
            System.out.println("Bat loi du lieu vao bi sai " + ex.getMessage());
        }
    }
}
