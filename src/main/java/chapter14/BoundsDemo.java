package chapter14;

public class BoundsDemo {
    public static void main(String[] args) {
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> iob = new Stats<>(inums);
        double v = iob.average();
        System.out.println("Average: " + v);

        Double dnums[] = {1.1,1.2,1.3,1.4,1.5};
        Stats<Double> dob = new Stats<>(dnums);
        double w = dob.average();
        System.out.println("Average: " + w);


        //Этот код не скомпилируется, так как класс String
        //не является производным от класса NumЬer
        // String strs[] = { "1", "2", "3", "4", "5" };
        // Stats<String> strob = new Stats<String>(strs);
        // douЫe х = strob.average();
        // System.out.println("Cpeднee значение strob равно " + v);
    }

}
