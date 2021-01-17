package homework.dynamicarray;

public class DynamicArrayTest {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();
        for (int i = 0; i < 20; i++) {
            da.add(i);
        };

        da.print();
        System.out.println();

        System.out.println(da.getByIndex(3));
        System.out.println(da.getByIndex(21));

        System.out.println(da.max());
        System.out.println(da.min());

        da.deleteByIndex(3);
        da.print();

        System.out.println();

        da.deleteByValue(11);
        da.print();
        da.deleteByValueFirst(2);
        System.out.println();

        int[] startEnd = da.subArray(5,9);
        for (int result:startEnd) {
            System.out.print(result + " ");
        }

        System.out.println();

        int[] start = da.subArray(5);
        for (int result:start) {
            System.out.print(result + " ");
        }
    }
}
