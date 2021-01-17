package chapter14;

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> iob = new Gen<>(88);

        iob.showType();

        int v = iob.getOb();
        System.out.println("Знaчeниe: " + v);
        System.out.println();

        Gen<String> strob = new Gen<>("Тест обощений");
        strob.showType();

        String str = strob.getOb();
        System.out.println("Значение " + str);

    }
}
