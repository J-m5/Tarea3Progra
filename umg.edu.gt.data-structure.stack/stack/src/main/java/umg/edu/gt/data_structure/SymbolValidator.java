package umg.edu.gt.data_structure;

public class SymbolValidator {

    public boolean validate(String expression) {

        MyStack<Character> stack = new MyStack<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (isOpen(ch)) {
                stack.push(ch);
            } 
            else if (isClose(ch)) {

                Character top = stack.pop();

                if (top == null) return false;

                if (!matches(top, ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean isClose(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '[' && close == ']')
            || (open == '{' && close == '}');
    }
}