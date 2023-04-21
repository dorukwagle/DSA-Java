package structures.Stacks;

import java.util.Map;
import java.util.Stack;

public class BalancedExpression {
        private final Map<Character, Character> map =
                Map.of('(', ')', '[', ']', '{', '}', '<', '>');
    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()){
            if(map.containsKey(c))
                stack.push(c);

            if(map.containsValue(c)){
                if(stack.isEmpty())
                    return false;
                if(c != map.get(stack.pop()))
                    return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        var exp = new BalancedExpression();
        String expression = "()()()()<>";
        if(exp.isBalanced(expression))
            System.out.println("Compiled Successfully");
        else
            System.out.println("Syntax Error");
    }
}
