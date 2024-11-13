import java.util.*;

public class BooleanExpressionParser {
    private static final Map<String, Integer> precedenceMap = Map.of(
        "!", 3,
        "*", 2, 
        "+", 1   
    );

    public static List<String> infixToPostfix(String expression) {
        Stack operatorStack = new Stack();
        List<String> output = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(expression, "+*()!", true);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            if (token.isEmpty()) continue;

            if (isVariable(token)) {
                output.add(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.add(operatorStack.pop());
                }
                operatorStack.pop(); // Pop the '('
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    output.add(operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }

        
        while (!operatorStack.isEmpty()) {
            output.add(operatorStack.pop());
        }

        return output;
    }

    public static boolean isVariable(String token) {
        return token.matches("[A-Z]");
    }

    public static boolean isOperator(String token) {
        return precedenceMap.containsKey(token);
    }

    public static int precedence(String operator) {
        return precedenceMap.getOrDefault(operator, -1);
    }
}

