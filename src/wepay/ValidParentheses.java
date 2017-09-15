package wepay;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ValidParentheses
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidParentheses {
    /*
    括号匹配
    括号匹配提了一下如果有几千种括号需要匹配，怎么优化，算是设计模式？ 然后分析了时间复杂度是否会因为符号增多而增加.
    把判断符号的方法独立出来，减少依赖
     */
    public boolean isValid(String s) {
        if (s ==  null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }

        return stack.isEmpty();
    }
}
