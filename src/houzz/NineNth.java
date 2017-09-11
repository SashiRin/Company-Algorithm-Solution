package houzz;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : NineNth
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class NineNth {
    /**
     * Remove any number containing 9 like 9, 19, 29, ... 91, 92, ... 99, 109...
     Write a function that returns the nth number.
     E.g.  newNumber(1) = 1  newNumber(8) = 8, newNumber(9) = 10, 最后给了hint把数变成9-based
     * @param n
     * @return
     */
    public int nthNumber(int n) {
        return Integer.valueOf(Integer.toString(n, 9));
    }
    public static String nthNumber2(int n){
        int base = 9;
        char[] digits = new char[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
        StringBuilder str = new StringBuilder("");
        if(0==n){
            str.append(digits[0]);
        }else{
            Stack<Character> s = new Stack<Character>();
            while(n != 0){
                s.push(digits[n%base]);
                n/=base;
            }
            while(!s.isEmpty()){
                str.append(s.pop());
            }
        }
        return str.toString();
    }
}
