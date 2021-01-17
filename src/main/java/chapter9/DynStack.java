package chapter9;

public class DynStack implements IntStack {

    private int stck[];
    private int tos;

    DynStack(int size) {
        stck = new int[size];
    }

    @Override
    public void push(int item) {
        // если стек заполнен, выделить память
        // под стек большего размера
        if (tos == stck.length - 1) {
            int temp[] = new int[stck.length * 2];
            for (int i = 0; i < stck.length; i++) {
                temp[i] = stck[i];
            }
            stck = temp;
            stck[++tos] = item;
        } else {
            stck[++tos] = item;
        }
    }

    @Override
    public int pop() {
        if (tos < 0){
            System.out.println("Cтeк не загружен");
            return 0;
        }else
            return stck[tos --];
    }
}
