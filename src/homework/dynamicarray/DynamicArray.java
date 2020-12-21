package homework.dynamicarray;

public class DynamicArray {

    private int[] array = new int[10];
    private int size = 0;

    public void add(int value) {

        if (size == array.length) {
            extend();
        }
        array[size++] = value;
    }

    private void extend() {
        int[] newArray = new int[array.length + 10];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int getByIndex(int index) {
        if (index < size) {
            return array[index];
        } else {
            System.out.println("Index Out Of Bound Exception ");
            return -1;
        }
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public int max() {
        int max = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public int min() {
        int min = array[0];
        for (int i = 0; i < size; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public void deleteByIndex(int index) {
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void deleteByValue(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteByIndex(i);
            }
        }
    }

    public void deleteByValueFirst(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                deleteByIndex(i);
                break;
            }
        }
    }

    public int[] subArray(int startIndex, int endIndex) {
        int[] newSubArray = new int[endIndex - startIndex];
        int index = 0;
        for (int i = startIndex; i < endIndex; i++) {
            newSubArray[index++] = array[i];
        }
        return newSubArray;
    }

    public int[] subArray(int startIndex) {
        int[] newSubArray = new int[size - startIndex];
        int index = 0;
        for (int i = startIndex; i < size; i++) {
            newSubArray[index++] = array[i];
        }
        return newSubArray;
    }


}
