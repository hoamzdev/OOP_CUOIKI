package Chuong5;

public class NgoaiLeChiaKhong {
    public static void main(String[] args) {
        int soA = 10;
        int soB = 0;
        try {          
            int ketQua = soA / soB; // Dòng này sẽ ném ra ArithmeticException
            System.out.println("Kết quả là: " + ketQua); // Dòng này sẽ không chạy
        } catch (ArithmeticException e) { // Khối này bắt lỗi chia cho 0           
            System.out.println("Lỗi rồi: Không thể chia cho số 0.");
            System.out.println("Thông điệp lỗi chi tiết: " + e.getMessage());
        } finally {            
            System.out.println("Khối finally luôn được thực thi.");
        }
        System.out.println("Chương trình vẫn tiếp tục chạy sau khi xử lý lỗi.");
    } 
}
