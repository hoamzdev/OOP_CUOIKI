package Chuong3;

public class BankAccount2 {

    private String owner;
    private double balance;

    public BankAccount2(String owner_,double balance_){
        owner =  owner_;
        balance = balance_;
    }

    //lop con
    class Transaction{
        private String type;//kieu giao dich
        private double amount;//so tien giao dich

        public Transaction(String type_,double amount_){
            type = type_;
            amount = amount_;
        }

        //process
        public void process() {
            if (type.equals("deposit")) {//neu la nap tien
                balance += amount;
            } else if (type.equals("withdraw") && balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Giao dich ko hop le");
                return;
            }
            //log
            System.out.println("Thực hiện " + type + " " + amount + "₫ thành công. Số dư mới: " + balance + "₫");
        }
    }

    public void showBalance(){
        System.out.println("So du hien tai cua " + owner + " : " + balance + "$");
    }
}
