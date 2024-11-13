import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;


public class TruthTableGenerator {
    public static void generateTruthTable(String expression) {
        List<String> postfix = BooleanExpressionParser.infixToPostfix(expression);
        Set<String> variables = extractVariables(expression);
        List<String> varList = new ArrayList<>(variables);


        System.out.println(String.join(" | ", varList) + " | " + expression);
        System.out.println("-".repeat(varList.size() * 4 + expression.length() + 3));

        int rows = (int) Math.pow(2, variables.size());

        for (int i = 0; i < rows; i++) {
            Map<String, Boolean> values = assignValues(varList, i);
            boolean result = evaluatePostfix(postfix, values);

            for (String var : varList) {
                System.out.print((values.get(var) ? "T" : "F") + " | ");
            }
            System.out.println(result ? "T" : "F");
        }
    }

    private static Set<String> extractVariables(String expression) {
        Set<String> variables = new TreeSet<>();
        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) {
                variables.add(String.valueOf(ch));
            }
        }
        return variables;
    }

    private static Map<String, Boolean> assignValues(List<String> varList, int rowIndex) {
        Map<String, Boolean> values = new HashMap<>();
        for (int j = 0; j < varList.size(); j++) {
            values.put(varList.get(j), (rowIndex & (1 << (varList.size() - j - 1))) != 0);
        }
        return values;
    }

    private static boolean evaluatePostfix(List<String> postfix, Map<String, Boolean> values) {
        Stack operandStack = new Stack();

        for (String token : postfix) {
            if (BooleanExpressionParser.isVariable(token)) {
                operandStack.push(values.get(token).toString());
            } else if (token.equals("!")) {
                boolean operand = Boolean.parseBoolean(operandStack.pop());
                operandStack.push(Boolean.toString(!operand));
            } else {
                boolean right = Boolean.parseBoolean(operandStack.pop());
                boolean left = Boolean.parseBoolean(operandStack.pop());

                switch (token) {
                    case "+":
                        operandStack.push(Boolean.toString(left || right));
                        break;
                    case "*":
                        operandStack.push(Boolean.toString(left && right));
                        break;
                }
            }
        }
        return Boolean.parseBoolean(operandStack.pop());
    }
}
