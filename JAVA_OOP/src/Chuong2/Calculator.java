package Chuong2;

public class Calculator {
    /**
     * //cong hai so nguyen
     * @param a so thu nhat
     * @param b so thu hai
     * @return a + b
     */
    public int add(int a,int b){
        return a + b;
    }

    /**
     * Tru hai so nguyen
     * @param a so thu nhat
     * @param b so thu hai
     * @return a - b
     */
    public int subtract(int a,int b){
        return a - b;
    }

    /**
     * Nhan hai so nguyen
     * @param a so nguyen thu nhat
     * @param b so nguyen thu nhat
     * @return a* b
     */
    public int multiply(int a,int b){
        return a * b;
    }

    /**
     * chia hai so nguyen
     * @param a so nguyen thu nhat
     * @param b so nguyen thu nhat
     * @return a / b
     */

    public double divide(int a,int b){
        if(b != 0) return (double) a / b;
        System.out.println("Khong chia dc cho so khong");
        return 1e8F;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.add(2,3));
    }
}

