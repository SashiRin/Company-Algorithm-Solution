package indeed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : ReverseHTML
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO            &q&euro;1;这种情况没办法解决
 */
public class ReverseHTML {
    public static String reverseHTML(String res){
        if(res == null || res.length() == 0) return res;
        List<String> tokens = new LinkedList<String>();
        int len = res.length();
        int pointer = 0;
        int leftBorder = 0;
        //1234&euro;
        while(pointer < len){
            char curChar = res.charAt(pointer);
            if(curChar != '&'){
                pointer++;
            } else {
                if (pointer + 1 < len && res.charAt(pointer + 1) == '&') {
                    pointer++;
                    continue;
                }
                //reverse part before html, and store in tokens
                if(pointer != 0){
                    String beforeToken = reverse(res, leftBorder, pointer - 1);
                    tokens.add(beforeToken);
                    //update left
                    leftBorder = pointer;
                }
                //get html part, put into token
                StringBuilder sb = new StringBuilder();
                while(pointer < len && res.charAt(pointer) != ';'){
                    sb.append(res.charAt(pointer));
                    pointer++;
                }
                if(pointer < len){
                    sb.append(';');
                    tokens.add(sb.toString());
                    leftBorder = ++pointer;
                }
            }

        }
        //reverse the last part, put into token : left pointer to the end
        if(leftBorder < pointer){
            String afterToken = reverse(res, leftBorder, res.length()-1);
            tokens.add(afterToken);
        }

        StringBuilder result = new StringBuilder();
        for(int i = tokens.size()-1; i>= 0; i--){
            result.append(tokens.get(i));
        }

        return result.toString();
    }
    private static String reverse(String res, int leftBorder, int pointer) {
        StringBuilder sb = new StringBuilder();
        while(leftBorder <= pointer){
            sb.append(res.charAt(pointer));
            pointer--;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(reverseHTML("&euro"));
        System.out.println(reverseHTML("&q&euro;d;"));
        System.out.println(reverseHTML("&euro;"));
        System.out.println(reverseHTML("1234&euro;"));
        System.out.println(reverseHTML("1234&euro"));
        System.out.println(reverseHTML("1234&euro;324&euro;&euro;222"));
        System.out.println(reverseHTML("aaa;aaa &amp; bbb;;;"));
        System.out.println(reverseHTML("123&euro;432&euro;"));
        System.out.println(reverseHTML("a&&nbsp;;b&&"));
        System.out.println(reverseHTML("&&;;"));
    }
}
