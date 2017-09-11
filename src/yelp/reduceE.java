package yelp;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : yelp
 * File Name : reduceE
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class reduceE {

    public static String reduceE(String input) {
        char[] arr = input.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < arr.length) {
            if (arr[fast] != 'e') {
                arr[slow] = arr[fast];
                slow++;
                fast++;
            } else {
                if (slow > 0 && arr[slow - 1] == 'e') fast++;
                else {
                    arr[slow] = arr[fast];
                    slow++;
                    fast++;
                }
            }
        }
        return new String(arr, 0, slow);
    }

    public static void main(String[] args) {
        String input = "abbeeebbbbeeddedee";
        System.out.println(reduceE(input));
    }
}
