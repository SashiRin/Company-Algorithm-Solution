package twitter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Leetcode
 * Package Name : twitter
 * File Name : LongestPhrasesInATweet
 * Creator : Edward
 * Date : Aug, 2017
 * Description : Sliding Window
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=208310&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%255B3046%255D%255Bvalue%255D%3D20%26searchoption%255B3046%255D%255Btype%255D%3Dradio&page=1
 */
public class LongestPhrasesInATweet {

    public static int maxLength2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int res = 0;
        for (int cur : nums) {
            if (sum + cur <= k) {
                sum += cur;
                queue.offer(cur);
            } else {
                res = Math.max(res, queue.size());
                while (sum + cur > k) {
                    sum -= queue.poll();
                }
                sum += cur;
                queue.offer(cur);
            }
        }
        res = Math.max(res, queue.size());
        return res;
    }

    public static int maxLength(int[] a, int k) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int maxLen = 0;
        for(int cur : a){
            if(sum + cur <= k){
                queue.offer(cur);
                sum += cur;
            }else{
                while(sum + cur > k){
                    maxLen = Math.max(maxLen, queue.size());
                    int first = queue.poll();
                    sum -= first;
                }
                sum += cur;
                queue.offer(cur);
                maxLen = Math.max(maxLen, queue.size());
            }
        }
        maxLen = Math.max(maxLen, queue.size());
        return maxLen;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,1,2,3,4,5,2,1,4,2,4};
        System.out.println(maxLength2(a,6));
        System.out.println(maxLength(a, 6));
    }
}
