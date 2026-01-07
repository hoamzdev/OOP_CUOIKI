package Chuong3;

class Student1{
    private static int count = 0;//dem so luong sinh vien
    private String name;

    public Student1(String name){
        this.name = name;
        count++;//moi lan khoi tao 1 sv moi thi count tang nen 1
    }

    //lay sl sv
    public static int getStudentCount(){
        return count;
    }

    public static void main(String[] args) {
        Student1 s1 = new Student1("hoa");
        Student1 s2 = new Student1("Hoa");
        Student1 s3 = new Student1("DVH");

        System.out.println("Total sv : " + Student1.getStudentCount());
    }
}