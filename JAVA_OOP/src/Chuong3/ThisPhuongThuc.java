package Chuong3;

class Student2{
    private String name;

    public Student2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void show(Printer1 printer1){
        printer1.printStudent(this);
    }
}

class Printer1{
    public void printStudent(Student2 s){
        System.out.println("Ten sinh vien : " + s.getName());
    }
}

class Main2{
    public static void main(String[] args) {
        Student2 st2 = new Student2("hoa");
        Printer1 printer1 = new Printer1();
        st2.show(printer1);
    }
}