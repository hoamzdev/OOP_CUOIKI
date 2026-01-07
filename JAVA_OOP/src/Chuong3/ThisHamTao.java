package Chuong3;

class Student3{
    private String name;

    public Student3(String name){
        this.name = name;
        new Logger(this);
    }

    public String getName() {
        return name;
    }
}

class Logger{
    public Logger(Student3 st3){
        System.out.println("Tao logger cho sinh vien : " + st3.getName());
    }
}

class Main3{
    public static void main(String[] args) {
        Student3 student3 = new Student3("hoa");
    }
}