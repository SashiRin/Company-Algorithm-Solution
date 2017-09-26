package indeed;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : ValidatePython
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidatePython {
    /**
     * Python is validate by c before each line of code, so given a list of Strings
     which indicates the lines of Python code. Validate if it meets the requirement
     判断一段Python代码是否是合法的，会给出4个规则。
     已知两个，1.第一行不能缩进。2.一行冒号结尾的code，下一行必须比这一行缩进的多。
     主要是看缩进对不对。
     要求返回第一个出错的行数。

     follow up1: what is the last line is control block? 没有影响啊？？？
     follow up2: what if there is comment line ("  #")

     * @param lines
     * @return
     */
    public boolean validate(String[] lines){
        //就用stack来存之前的line就行
        Stack<String> stack = new Stack<>();
        for (String line : lines){
            /**
             * follow up2: what if there is comment line ("  #")
             * if (line.trim().charAt(0) == '#') continue;
             */
            int level = getIndent(line);
            //先检查是不是第一行
            if (stack.isEmpty()){
                if (level != 0) {
                    System.out.println(line);
                    return false;
                }
            }
            //再检查上一行是不是control statement
            else if (stack.peek().charAt(stack.peek().length()-1) ==':'){
                if (getIndent(stack.peek()) + 1 != level){
                    System.out.println(line);
                    return false;
                }
            }
            else {
                /*
                空空空abc
                空空bc ->合法，while检查可以
                 */
                while (!stack.isEmpty() && getIndent(stack.peek()) > level){
                    stack.pop();
                }
                /*
                空空abc
                空空bc ->合法，if检查可以

                空空abc
                空空空bc ->不合法，if检查不可以
                 */
                if (getIndent(stack.peek()) != level){
                    System.out.println(line);
                    return false;
                }
            }
            stack.push(line);
        }
        return true;
    }
    //这里如果它说n个空格算一次tab的话，就最后返回的时候res/n好了。     indent 缩进
    public int getIndent(String line){
        int res = 0;
        for (int i = 0; i < line.length(); i++){
            if (line.charAt(i) == ' '){
                res++;
            }
            else break;
        }
        return res;
    }
    public static void main(String[] args) {
        ValidatePython test = new ValidatePython();
        String[] lines = {
                "def:",
                " abc:",
                "  b2c:",
                "   cc",
                " b5c",
                "b6c"
        };
        System.out.println(test.validate(lines));
        //先这样吧，应该行了。
    }

}
