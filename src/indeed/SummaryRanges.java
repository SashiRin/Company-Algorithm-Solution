package indeed;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : SummaryRanges
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SummaryRanges {

    /**
     * follow up 1 : duplicates
     * follow up 2 : 如果输入为[1,2,3,4,5,.......100000, 300000] 这种情况怎么办，有没有更好的方式， 最坏情况和最好情况
     * follow up 3 : 输入改为无序、有重复，请设计优于O(n)时间复杂度的算法 Interval 解法
     * follow up 4 : 万一不是连续的。例子 {1，3，5，6，10，14}   要输出 “1-5/2 , 6-14/4”  使用逗号分隔开。2和4代表的是这些数的差，也就是steps
     *
     * @param nums
     * @return
     */
    // time : O(n)
    public List<String> summaryRanges(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            //follow up 1 : duplicates : while (i < length - 1 && (nums[i] + 1 == nums[i + 1] || nums[i] == nums[i + 1]))
            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                result.add(num + "->" + nums[i]);
            } else {
                result.add(num + "");
            }
        }
        return result;
    }

    /**
     * follow up 2 : 如果输入为[1,2,3,4,5,.......100000, 300000] 这种情况怎么办，有没有更好的方式， 最坏情况和最好情况
     * 最好情况：1,2,3,4,5,.......300000
     * 最坏情况：1, 3,4,5....300000
     * @param nums
     * @return
     */
    public static List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return list;
        }
        int start = 0;
        while(start < nums.length) {
            int j = binarySearch(nums, start, nums.length);
            String s = String.valueOf(nums[start]);
            String e = String.valueOf(nums[j]);
            if(s.equals(e)) {
                list.add(e);
            } else {
                list.add(s + "->" + e);
            }
            start = j + 1;
        }
        return list;
    }
    public static int binarySearch(int[] nums, int start, int end) {
        int l = start, r = end;
        while(l + 1 < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] - nums[l] > mid - l) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l;
    }

    /**
     * follow up 3 : 输入改为无序、有重复，请设计优于O(n)时间复杂度的算法 Interval 解法
     */
    static class Interval {
        public int start;
        public int end;
        public int getStart() {
            return start;
        }
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static List<String> printInterval(int[] arr) {
        HashSet<Integer> set = new HashSet < > ();
        HashSet<Integer> setUsed = new HashSet < > ();
        if (arr.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        //StringBuilder sb = new StringBuilder(); 如果return 是string
        ArrayList <Interval> intervalList = new ArrayList<>();
        for (int i: arr) {
            set.add(i);
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer num = it.next();
            if (setUsed.contains(num)) {
                continue;
            }
            int start = num;
            int end = num;
            while (set.contains(end + 1)) {
                end++;
                setUsed.add(end);
            }

            while (set.contains(start - 1)) {
                start--;
                set.remove(start);
                setUsed.add(end);
            }

            intervalList.add(new Interval(start, end));
        }

        intervalList.sort(Comparator.comparing(Interval::getStart));

        for (Interval interval: intervalList) {
            int start = interval.start;
            int end = interval.end;
            if (start == end) {
                res.add(start + "");
                //sb.append(start + ",");
            } else {
                res.add(start + "->" + end);
                //sb.append(start + "-" + end + ",");
            }
        }
        return res;
        //sb.deleteCharAt(sb.length() - 1);
        //return sb.toString();
    }

    /**
     * follow up 4 : 万一不是连续的。例子 {1，3，5，6，10，14}   要输出 “1-5/2 , 6-14/4”  使用逗号分隔开。2和4代表的是这些数的差，也就是steps
     * @param nums
     * @return
     */
    public static String summaryRanges4(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        int curSteps = 0;
        while(end < nums.length){
            if( end + 1 < nums.length)
                curSteps = nums[end+1] - nums[end];
            while(end + 1 < nums.length && nums[end] + curSteps == nums[end+1]){
                end++;
            }
            if(end == nums.length - 1)
                sb.append(getRange(nums,start,end, curSteps));
            else
                sb.append(getRange(nums,start,end, curSteps)+",");
            end++;
            start = end;
        }
        return sb.toString();
    }

    public static String getRange(int[] nums,int start,int end,int steps){
        return (start == end) ? String.valueOf(nums[start]) : nums[start] + "-"+nums[end]+"/"+steps;
    }

    public static void main(String[] args) {
        int[] test2 = {1,2,3,4,5,6,7,8,10};
        summaryRanges2(test2);
        int[] res = new int[]{7, 1, 5, 4, 2, 0, 0};
        int[] test = new int[]{1,3,5,6,10,14};

        /*List<String> ss = printInterval(res);
        for (String s : ss) {
            System.out.println(s);
        }*/
        //System.out.println(summaryRanges4(test));
    }
}
