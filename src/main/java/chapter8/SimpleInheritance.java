package chapter8;

class A  {
    int i, j;

    void showij() {
        System.out.println("i и j: "+ i +" "+ j);
    }
}

class B extends A {
    int k;

    void showk(){
        System.out.println("k: "+ k);
    }

    void sum () {
        System.out.println("i+j+k: "+ (i+j+k));
    }
}

public class SimpleInheritance {
    public static void main(String[] args) {
        A superOb = new A();
        B subOb = new B();

        superOb.i = 10;
        superOb.j = 20;
        System.out.println("Coдepжимoe объекта superOb: ");
        superOb.showij();
        System.out.println();

        subOb.i = 5;
        subOb.j = 7;
        subOb.k = 6;
        System.out.println("Coдepжимoe объекта subOb: ");
        superOb.showij();
        subOb.showk();

        System.out.println();
        subOb.sum();
    }
}
