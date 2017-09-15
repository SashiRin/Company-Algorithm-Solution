package wepay;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : BasicCalculator
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class BasicCalculator {
    /*
    给的例子是 (+ (* 2 3) (/ (+ 4 5) 3)) returns 9
    观察例子可以看到括号都会和数字或者运算符在一个token里，然后不同的token被空格隔开，运算符和数字一定不在一个token里。
     */
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + (int)(c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop();
                res += stack.pop();
            }
        }
        if (num != 0) res += sign * num;
        return res;
    }

    public int calculate2(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) -'0';
            }
            if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '+') {
                    stack.push(num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }


}
