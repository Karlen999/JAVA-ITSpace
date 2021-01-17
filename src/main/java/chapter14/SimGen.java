package chapter14;

public class SimGen {
    public static void main(String[] args) {

        TwoGen<Integer, String> tgobj = new TwoGen<>(88,"Generics");
        tgobj.showTypes();

        int v = tgobj.getOb1();
        System.out.println("Values: " + +v);

        String str = tgobj.getOb2();
        System.out.println("Values: " + str);
    }
}
