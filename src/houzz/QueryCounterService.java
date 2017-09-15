package houzz;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : QueryCounterService
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class QueryCounterService {

    /**
     * time : O(k): 每次插的时候和前一个比较，如果frequency大的话就前后互换, 否则不动 用Map+linkedList
     * 单机query存不下怎么办， 还问了service挂掉了怎么recover？
     */

    HashMap<String, Integer> map = new HashMap<>();
    int count = 0;//bucket sort

    void addCount(String query) {
        // add query count + 1
        if (map.containsKey(query)) {
            map.put(query, map.get(query) + 1);
        } else {
            map.put(query, 1);
        }
        count++;
    }

    int getCount(String query) {
        // return current query count
        return map.get(query);
    }

    List<String> getTopKFrequentQueries(int k) {
        // get current top most frequent k queries sorted by the counter
        // time : o(nlogn)
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a,b)->(b.getValue() - a.getValue()));
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<String> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<String, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }

        // bucket sort : O(n)
        List<String>[] bucket = new List[count + 1];
        for (String key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }
    /*
    // quickSelect(optimized quickSort,iterative):average O(n) time,worst case(all nums are are the same) O(n^2) time, O(1) space
        public class Solution {
            public int findKthLargest(int[] nums, int k) {
                if (nums == null || nums.length == 0 || k < 1) {
                    return 0;
                }
                //if find k largest, add code below:
                //int index = -1;
                int left = 0;
                int right = nums.length - 1;
                while (true) {
                    int pos = partition(nums, left, right);
                    if (pos + 1 == k) {//if kth largest found
                        return nums[pos];//or set index = pos; return; (k largest)
                    } else if (pos + 1 > k) {//if kth largest is on pos's left
                        right = pos - 1;
                    } else {
                        left = pos + 1;//if kth largest is on pos's right
                    }
                }
                //if the output should be a array in sorted in acsending order, add the code below, which is O(klogk) time
                //Arrays.sort(res);
                //return res;
            }

            private int partition(int[] nums, int left, int right) {
                Random rand = new Random();//choose a random pivot,or you can just pick nums[left] to be pivot
                int index = rand.nextInt(right - left + 1) + left;//remember to add + left !!!
                int pivot = nums[index];//choose nums[index] to be the pivot
                swap(nums, left, index);//swap pivot the the front; index, not pivot !!
                int l = left + 1;
                int r = right;
                while (l <= r) {//we partition the array so that pos's left nums are >= pivot, its right nums are <= pivot
                    if (nums[l] < pivot && nums[r] > pivot) {//if wanna find kth smallest,just put smaller on left,bigger on right
                        swap(nums, l, r);//find smallest?which is modified to nums[l] > pivot && nums[r] < pivot
                    }
                    if (nums[l] >= pivot) {//find smallest?which is modified to nums[l] <= pivot
                        l++;
                    }
                    if (nums[r] <= pivot) {//find smallest?which is modified to nums[r] >= pivot
                        r--;
                    }
                }
                swap(nums, left, r);//put the pivot back to correct pos so that its left nums are >= pivot, right nums are <= pivot
                return r;//return the pos of pivot
            }

            private void swap(int[] nums, int i, int j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        test case:
        3,2,1,5,6,4
        4
        [4, 6, 5, 1, 2, 3]
        [5, 6, 4, 1, 2, 3]
        6
        [6, 5, 4, 1, 2, 3]
        [6, 5, 4, 1, 2, 3]
        5
        [6, 5, 4, 1, 2, 3]
        [6, 5, 4, 1, 2, 3]
     */
}
