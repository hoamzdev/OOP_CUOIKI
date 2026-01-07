package Chuong3;

class Person2{
    private String name;
    private int age;

    public Person2 setName(String name) {
        this.name = name;
        return this;
    }

    public Person2 setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return name + "  " + age;
    }
}

class Main1{
    public static void main(String[] args) {
        Person2 p = new Person2();
        p = p.setName("hoa").setAge(12);
        System.out.println(p);
    }
}