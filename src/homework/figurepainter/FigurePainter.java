package homework.figurepainter;

public class FigurePainter {


    /**
     * Գրել կոդ, որը կպատկերի այս եռանկյունը։
     * *
     * * *
     * * * *
     * * * * *
     */
    void figureOne(int line) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Գրել կոդ, որը կպատկերի այս եռանկյունը։
     * <p>
     * *
     * * *
     * * * *
     * * * * *
     */
    void figureTwo(int line) {
        for (int i = 0; i < line; i++) {
            for (int j = line; j > i; j--) {
                System.out.print("  ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Գրել կոդ, որը կպատկերի այս եռանկյունը։
     * <p>
     * * * * *
     * * * *
     * * *
     * *
     */
    void figureThree(int line) {
        for (int i = line; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**
     * Գրել կոդ, որը կպատկերի այս եռանկյունը։
     * <p>
     * * * * *
     * * * *
     * * *
     * *
     */
    void figureFour(int line) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            for (int j = line; j > i; j--) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /**
     * Գրել կոդ, որը կպատկերի այս եռանկյունը։
     * <p>
     * <p>
     * *
     * * *
     * * * *
     * * * * *
     * * * *
     * * *
     * *
     */
    void figureFive(int lineOne, int lineTwo) {
        for (int i = 0; i < lineOne; i++) {
            for (int j = lineOne; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < lineTwo; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = lineTwo; j > i; j--) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}


