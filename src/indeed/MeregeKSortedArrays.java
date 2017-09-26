package indeed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : MeregeKSortedArrays
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MeregeKSortedArrays {
    /**
     * Number of elements in the heap = k
     Time to heapify = O(logk)
     O(logk)
     No of times this heapify process repeats = Total number of elements in k sorted arrays = n
     Therefore, overall time complexity of the algorithm = O(nlogk)
     O(nlogk).
     要去除duplicate

     */
    private static class ArrayContainer implements Comparable<ArrayContainer> {
        int []array;
        int index;
        public ArrayContainer (int []array, int index) {
            this.array = array;
            this.index = index;
        }

        @Override
        public int compareTo(ArrayContainer o) {
            return this.array[index] - o.array[o.index];
        }
    }

    public static int[] mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> ret = new ArrayList<>();
        if (arrays == null || arrays.length == 0) {
            return new int[]{};
        }
        PriorityQueue<ArrayContainer> pq = new PriorityQueue<>();

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length != 0) {
                ArrayContainer ac = new ArrayContainer(arrays[i], 0);
                pq.add(ac);
            }
        }
        while (!pq.isEmpty()) {
            ArrayContainer ac = pq.poll();
            ret.add(ac.array[ac.index++]);
            if (ac.index < ac.array.length) {
                pq.add(ac);
            }
        }

        int[] res = new int[ret.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ret.get(i);
        }

        return res;
    }


    public static void main(String[] args){
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {0, 9, 10, 11};
        System.out.println(Arrays.toString( mergekSortedArrays(new int[][] {arr1, arr2, arr3})));
    }
}
