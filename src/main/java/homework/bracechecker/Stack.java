package homework.bracechecker;

public class Stack {

    private int[] array = new int[10];
    private int size;

    public Stack() {
        size = -1;
    }

    public void push(int value) {
        if (size == array.length) {
            extend();
        } else {
            array[++size] = value;
        }
    }

    private void extend() {
        int[] newArray = new int[array.length+10];
        System.arraycopy(array,0,newArray,0,array.length);
        array = newArray;
    }

    public int pop() {
        if (size < 0) {
            System.out.println("stack-ը դատարկ է");
            return 0;
        }else {
            return array[size--];
        }
    }

    public boolean isEmpty(){
        return (size == -1);
    }
}
