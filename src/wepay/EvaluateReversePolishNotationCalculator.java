package wepay;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : EvaluateReversePolishNotationCalculator
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class EvaluateReversePolishNotationCalculator {
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }
}
