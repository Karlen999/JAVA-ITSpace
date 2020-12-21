package homework.arrayutil;

public class ArrayUtil {


    int[] array = {2, 5, 8, 10, 32, 22, 11, 66, 12, 30};
    double sum = 0;

    // 1. Տպեք մասիվի բոլոր էլեմենտները

    void PrintArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
    }
    // 2. Տպեք մասիվի ամենամեծ թիվը

    void MaxValue() {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(max);
    }

    // 3. Տպեք մասիվի ամենափոքրը թիվը

    void MinValue() {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {

            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println(min);
    }

    // 4. Տպեք մասիվի բոլոր զույգ էլեմենտները

    void Evens() {
        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                System.out.print(array[i] + " ");
            }

        }
        System.out.println();
    }

    // 5. Տպեք մասիվի բոլոր կենտ էլեմենտները

    void Odds() {
        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 != 0) {
                System.out.print(array[i] + " ");
            }

        }
        System.out.println();
    }

    // 6. Տպեք զույգերի քանակը

    void EvenCount(int evenCount) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);
    }

    // 7.Տպեք կենտերի քանակը

    void OddCount(int oddCount) {

        for (int i = 0; i < array.length; i++) {

            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        System.out.println(oddCount);
    }

    // 9. Տպեք մասիվի էլեմենտների գումարը

    void SumOfArray() {
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        System.out.println(sum);
    }

    // 8.Տպեք մասիվի բոլոր թվերի միջին թվաբանականը

    void Average(double average) {

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        average = sum / (array.length);
        System.out.println(average);

    }
}

