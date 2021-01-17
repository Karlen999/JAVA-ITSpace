package classwork.chapter6;

public class BoxTest {

    public static void main(String[] args) {

        Box myBox1 = new Box(10,20,15);
        Box myBox2 = new Box(3,6,9);


        double vol = myBox1.volume();
        System.out.println(vol * 2);

        double vol2 = myBox2.volume();
        System.out.println(vol2);
    }
}
