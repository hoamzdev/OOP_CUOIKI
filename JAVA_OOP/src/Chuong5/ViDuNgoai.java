package Chuong5;

import java.util.Scanner;

class DivideByZeroException extends Exception{
    public DivideByZeroException(String message){
        super(message);
    }
}

public class ViDuNgoai {
    public static double chia(int a,int b) throws DivideByZeroException{
        //case phat sinh ngoai le
        if(b == 0){
            throw new DivideByZeroException("Khong chia dc cho khong");
        }
        return (double) a / b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số a: ");
        int a = sc.nextInt();
        System.out.print("Nhập số b: ");
        int b = sc.nextInt();
        
        try {
            double res = chia(a, b);
            System.out.println(res);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Tiep tuc chay");
    }
}
