package goldmanSachs;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : goldmanSachs
 * File Name : ReverseSentence
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class ReverseSentence {

    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while (left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
        return new String(str);
    }
}
