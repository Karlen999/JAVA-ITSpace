package homework.chararray;

public class CharArray {

    // 1.
    void BeginEndSpace(int beginIndex, int index) {
        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' '};
        int endIndex = text.length - 1;

        while (beginIndex < endIndex && text[beginIndex] == ' ') {
            beginIndex++;
        }

        while (beginIndex < endIndex && text[endIndex] == ' ') {
            endIndex--;
        }

        char[] result = new char[(endIndex - beginIndex) + 1];

        for (int i = beginIndex; i < endIndex + 1; i++) {
            result[index++] = text[i];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }

    // 2. count the number of characters

    char[] bolola = {'b', 'o', 'l', 'o', 'l', 'a'};

    void CountNumber(char c, int count) {

        for (char x : bolola) {
            if (x == c) {
                count++;
            }
        }
        System.out.println(count);
    }

    // 3. print 2 middle symbol

    void MiddleSymbol() {
        System.out.println(bolola[bolola.length / 2 - 1] +
                " " + (bolola[bolola.length / 2]));
    }

    // 4. print true if massive ends with 'ly'

    void MassiveEnd(boolean bool) {
        for (int i = 0; i < bolola.length; i++) {
            if (bolola[bolola.length - 1] == 'y' && bolola[bolola.length - 2] == 'l') {
                bool = true;
            }
        }
        System.out.println(bool);
    }

    // 5. check for the letter 'b' from the left and from the right

    void CheckLetter(boolean bool) {
        char[] bolola1 = {'b', 'a', 'b', 'o', 'l', 'a'};
        for (int i = 1; i < bolola1.length - 1; i++) {
            if (bolola1[i - 1] == 'b' && bolola1[i + 1] == 'b') {
                bool = true;
            }
        }
        System.out.println(bool);
    }
}

