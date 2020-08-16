package 栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * @author rnang0
 * @date 2020/8/12
 **/
public class _20_有效的括号 {

    private static HashMap<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put('(', ')');
        mappings.put('{', '}');
        mappings.put('[', ']');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (mappings.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (c != mappings.get(stack.pop())) {
                    return false;
                }

            }

        }
        return stack.isEmpty();
    }
}
