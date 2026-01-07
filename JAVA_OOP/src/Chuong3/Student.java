package Chuong3;

public class Student {
    private String name;
    private int age;

    public void setName(String name_) {
        name = name_;
    }

    public void setAge(int age_) {
        if (age >= 0) {  // kiểm tra hợp lệ
            age = age_;
        } else {
            System.out.println("Tuổi không hợp lệ!");
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


