package yelp;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : yelp
 * File Name : reduce
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class reduce {
    public static String reduce(String input) {
        char[] array = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < array.length) {
            if (slow > 0 && array[slow - 1] == array[fast]) {
                while (fast < array.length && array[fast] == array[slow - 1]) {
                    fast++;
                }
            } else {
                array[slow] = array[fast];
                slow++;
                fast++;
            }
        }
        return new String(array, 0, slow);
    }
}
