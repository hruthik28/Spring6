package org.example;

public class Dev {
    public Dev(){
        System.out.println("Dev const");
    }
//    private int age;
//    private Laptop laptop;

//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        this.laptop = laptop;
//    }

//    public Dev(Laptop laptop){ //constructor injection
//        this.laptop=laptop;
//    }

//    public int getAge() {
//        return age;
//    }
//    public void setAge(int age) {
//        this.age = age;
//    }

//    public Dev(int age){ //constructor injection
//        this.age=age;
//    }

    private Computer comp;

    public Computer getComp() {
        return comp;
    }

    public void setComp(Computer comp) {
        this.comp = comp;
    }

    public void build(){
        System.out.println("build");
        comp.compile();
    }
}
