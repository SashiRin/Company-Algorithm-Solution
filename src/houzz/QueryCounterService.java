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
}
