package chapter14;

public class Gen<T> {
    T ob;

    Gen(T o){
        ob = o;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println("Tипoм Т является " + ob.getClass().getName());
    }
}
