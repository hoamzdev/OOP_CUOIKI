package Chuong3;

public class BankAccount {
    private double balance;//so du tai khoan

    public BankAccount(double initialBalance) {
        if (isValidAmount(initialBalance)) {
            balance = initialBalance;
        } else {
            balance = 0;
            System.out.println("Số dư ban đầu không hợp lệ. Đặt thành 0.");
        }
    }

    public void deposit(double amount) { // Gửi tiền
        if (isValidAmount(amount)) { // Gọi phương thức private
            balance += amount;
            logTransaction("Gửi tiền: " + amount); // Gọi phương thức private
        } else {
            System.out.println("Số tiền gửi không hợp lệ.");
        }
    }

    public void withdraw(double amount) { // Rút tiền
        if (isValidAmount(amount) && amount <= balance) {// Gọi phương thức private
            balance -= amount;
            logTransaction("Rút tiền: " + amount); // Gọi phương thức private
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc không đủ số dư.");
        }
    }

    public double getBalance() {
        return balance;
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    private void logTransaction(String message) {// Phương thức private
        // Trong thực tế có thể có logic ghi file/database phức tạp ở đây
        System.out.println("[LOG] Giao dịch thành công: " + message + ". Số dư mới: " + balance);
    }
}
