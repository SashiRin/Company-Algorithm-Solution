package houzz;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : MovingAverage
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
class Event{

    int val;
    long startTime;
    // int size;

    public Event(int val, long time){
        this.val = val;
        this.startTime = time;
        //this.size = 1;
    }
}
public class MovingAverage {
    /**
     * Given a stream of input, and a API int getNow() to get the current time stamp,
     Finish two methods:

     1. void record(int val) to save the record.
     2. double getAvg() to calculate the averaged value of all the records in 5 minutes.

     follow up 1 : memory不够大怎么办（数据点非常密集，5分钟就把内存爆了） 用Deque
     数据点密集的话，选择10秒的时间段，合并数据：每个Event是在一段10s内的数据和，val是10s内的val和，加一个size变量记录有多少数据
     得到一个10秒的和和数据数量，那么queue
     size就被一个int变量替换掉，这样丢掉过期数据的时候要更新sum和数据总和。这样会造成一定的偏差。

     follow up 2 : find Median

     */

    private Queue<Event> queue;
    // follow up 1 : private Deque<Event> queue;
    private long sum;
    // follow up 1 : private int dataNum = 0;

    public MovingAverage() {
        queue = new LinkedList<>();
        sum = 0;
    }

    public void record(int val){
        removeExpireEvent();
        long curTime = System.currentTimeMillis();
        Event event = new Event(val, curTime);
        queue.offer(event);
        sum += val;
        /*
        follow up 1：代码
        long curTime = System.currentTimeMillis();
        Event last = queue.peekLast();
        if (curTime - last.time < 10000){
            last.size += 1;
            last.val += val;
        } else {
            Event event = new Event(val, curTime);
            queue.offer(event);  // = offerLast
        }
        sum += val;
        dataNum += 1;
         */
    }

    public double getAvg(){
        removeExpireEvent();
        if (!queue.isEmpty()){
            return (double) sum/queue.size();
            //return (double) sum/dataNum;
        }
        return 0.0;
    }

    private void removeExpireEvent(){
        long curTime = System.currentTimeMillis();
        while (!queue.isEmpty() && isExpired(curTime, queue.peek().startTime)){
            Event curE = queue.poll();
            sum -= curE.val;
        }
        /*
        while (!queue.isEmpty() && isExpired(curTime, queue.peekFirst().startTime)){
            Event curE = queue.poll();
            sum -= curE.val;
            dataNum -= curE.size;
        }
         */
    }

    private boolean isExpired(long curTime, long startTime){
        return curTime - startTime > 300;  //  超过300毫秒，这个可能根据面试官会变
    }

    //实现find Median，其实O1操作的话，要始终维护两个heap，这样塞进去会很慢
    //原有基础上实现的话，那就直接quick select的办法了。
    //复杂度是On，因为每次average case是去掉一半，就是O(n)+O(n/2)+O(n/4)+... 最后出来是O(2n)
    //那这个需要把整个queue给倒出来再塞回去。
    public double getMedian(){
        removeExpireEvent();
        int[] temp = new int[queue.size()];
        for (int i = 0; i<queue.size(); i++){
            temp[i] = queue.poll().val;
        }
        //这里还得把queue还原回去,先不写了。
        int len = temp.length;
        if (len % 2 == 0){
            return 0.5*(findKth(temp, len/2, 0, len-1) + findKth(temp, len/2-1, 0, len-1));
        }
        return (double)findKth(temp, len/2, 0, len-1);
    }
    public int findKth(int[] temp, int k, int start, int end){
        int pivot = temp[start];
        int left = start, right = end;
        while (left < right){
            while (temp[right] > pivot && left < right){
                right--;
            }
            while (temp[left] <= pivot && left < right){
                left++;
            }
            swap(temp, left, right);
        }
        swap(temp, start, right);
        if (k == right){
            return pivot;
        }
        else if (k < right){
            return findKth(temp, k, start, right-1);
        }

        return findKth(temp, k, right+1, end);
    }
    public void swap(int[] temp, int left, int right){
        int i = temp[left];
        temp[left] = temp[right];
        temp[right] = i;
    }


}
