package wepay;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : WePay
 * Creator : Edward
 * Date : Aug, 2017
 * Description : TODO
 */
public class WePayOA {
    /**
     * wepay 的oa
     */

    public static int getPowerNumber(int index) {
        if (index < 0 ) return -1;
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 2; i < index + 3; i++) {
            for (int j = 2; j < 100; j++) {
                double temp = Math.pow(i, j);
                int num = 0;
                if (temp > Integer.MAX_VALUE) continue;
                else num = (int)temp;
                if (minHeap.contains(num)) {
                    continue;
                } else {
                    minHeap.add(num);
                }
            }
        }
        for (int i = 0; i < index; i++) {
            if (!minHeap.isEmpty()) {
                minHeap.poll();
            } else {
                break;
            }
        }
        return minHeap.isEmpty() ? -1 : minHeap.poll();
    }

    public static void main(String[] args) {
        System.out.println(getPowerNumber(11));
    }
}
