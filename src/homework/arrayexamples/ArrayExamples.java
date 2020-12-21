package homework.arrayexamples;

public class ArrayExamples {

    int[] array = {3, 1, -2, 7, -6, 44, 2, -7, 3, 25};


    // 1. find the number in array

    void ValueIsExists(int x, boolean bool) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                bool = true;
            }
        }
        System.out.println(bool);
    }

    // 2. find the index of number in array

    void IndexOfArray(int x, int index) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                index = i;
            }
        }
        System.out.println(index);
    }

    // 3. find value of this index

    void ValueOfIndex(int indexOfArray) {

        if (indexOfArray >= 0 && indexOfArray < array.length) {
            System.out.println(array[indexOfArray]);
        } else {
            System.out.println("Please input another index");
        }
    }

    // 4. find duplicate elements in the array

    void DuplicateElement() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("The number " + array[i] + " repeat ");
                }
            }
        }
    }

    // 5. sort from large to small

    void DescendingSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int temp;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }

        System.out.println();
    }

    // 6. sort from small to large

    void AscendingSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int temp;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + " ");
        }

        System.out.println();
    }

    // 7. print the second largest number in the array

    void SecondLargest() {
        int max1 = array[0];
        int max2 = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max1 < array[i]) {
                max2 = max1;
                max1 = array[i];
            } else {
                if (array[i] > max2) {
                    max2 = array[i];
                }
            }
        }
        System.out.println(max2);
    }
}

