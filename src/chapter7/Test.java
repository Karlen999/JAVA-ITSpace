package chapter7;

public class Test {
    int a, b;

    Test() {
        this.a = a;
        this.b = b;
    }

    boolean equalTo(Test o) {
        if (o.a == a && o.b == b) {
            return true;
        } else return false;
    }

    Test(int i, int j){
        a = i;
        b = j;
    }

    void meth(int i, int j) {
        i *= 2;
        j /= 2;
    }

    void meth(Test o){
        o.a *= 2;
        o.b /= 2;
    }
}

class PassOb {
    public static void main(String[] args) {
        Test ob1 = new Test();
        Test ob2 = new Test();
        Test ob3 = new Test();
        Test ob = new Test();
        Test ob4 = new Test(15,20);

        System.out.println(ob1.equalTo(ob2));
        System.out.println(ob1.equalTo(ob3));

        int a = 15;
        int b = 20;

        System.out.println(a + " " + b);

        ob.meth(a, b);

        System.out.println(a + " " + b);

        System.out.println(ob4.a + " " + ob4.b);

        ob.meth(ob4);

        System.out.println(ob4.a + " " + ob4.b);
    }
}
