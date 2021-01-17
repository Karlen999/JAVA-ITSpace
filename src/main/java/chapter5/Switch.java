package chapter5;

public class Switch {
    public static void main(String[] args) {
        int month = 4;
        String season;
        switch (month) {
            case 12:
            case 1:
            case 2:
                season = "Ձմեռ";
                break;
            case 3:
            case 4:
            case 5:
                season = "Գարուն";
                break;
            case 6:
            case 7:
            case 8:
                season = "Ամառ";
                break;
            case 9:
            case 10:
            case 11:
                season = "Աշուն";
                break;
            default:
                season = "Սխալ";
        }
        System.out.println("Ապրիլը " + season + " ամիսն է");
    }
}
