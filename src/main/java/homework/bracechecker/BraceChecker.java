package homework.bracechecker;

public class BraceChecker {

    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack stack = new Stack();
        for (int i = 0; i < text.length(); i++) {
            char brace = text.charAt(i);
            switch (brace) {
                case '(':
                case '[':
                case '{':
                    stack.push(brace);
                    break;
                case ')':
                    if (stack.pop() != '(') {
                        System.out.println("Error opened [ but closed " + brace + " at " + i);
                    }
                case ']':
                    if ((brace == ']' && stack.pop() != '[')) {
                        System.out.println("Error opened [ but closed " + brace + " at " + i);
                    }
                case '}':
                    if ((brace == '}' && stack.pop() != '{')) {
                        System.out.println("Error opened [ but closed " + brace + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error! The closing bracket is missing");
        }
    }
}
