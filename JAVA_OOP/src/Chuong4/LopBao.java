package Chuong4;

public class LopBao {

    public static void main(String[] args) {
        int n = 123;//kieu nguyen thuy
        Integer a = n;//auto boxing 
        Integer b = 20;
        int m = b;//unboxing : Integer -> int

        System.out.println("n= " + n);
        System.out.println("a= " + a);
        System.out.println("m= " + m);
        System.out.println("b= " + b);
        System.out.println("n+b= " + (n + b));

        int x = b.intValue(); // Integer → int 
        // int → Integer
        Integer y = Integer.valueOf(n);
        // Chuyển số thành chuỗi
        String s1 = a.toString(); // Qua lớp bao
        String s2 = String.valueOf(n);// Qua kiểu int
        // Lấy giá trị lớn nhất của kiểu int
        int max = Integer.MAX_VALUE;
        System.out.println("MAX = " + max);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
