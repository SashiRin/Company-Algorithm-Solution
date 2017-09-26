package indeed;

import java.util.*;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : MergeKSortedStreams
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MergeKSortedStreams {
    /**
     * Given n sorted stream, and a constant number k. The stream type is like iterator
     and it has two functions, move() and getValue(), find a list of numbers that each
     of them appears at least k times in these streams. Duplicate numbers in a stream
     should be counted as once.

     Note: In the interview, we should use min heap method

     给n个stream，每个stream都是排好序的，找出现k次或以上的元素。在一个stream出现多次的算作1次。
     最后返回的就是一群数字，每个都在n个stream里面出现 ≥k 次。

     其他解法： hashmap<Integer, List<Stream>> 一是内存消耗太大，二是二是不是in order的排序，你弄完了result还得sort一下这个算法不是最优。

     follow up: 是一个stream特别长，其他都很短，怎么处理。
     可以提前结束？min heap的size比k小的时候提前结束。
     */
    static class Stream{
        Iterator<Integer> iterator;
        public Stream(List<Integer> list){
            this.iterator = list.iterator();
        }
        public boolean move(){             //true means next postition has value  : hasNext（）
            return iterator.hasNext();
        }
        public int getValue(){
            return iterator.next();
        }
    }
    class Num{
        int val;
        Stream stream;
        public Num(Stream stream){
            this.stream = stream;
            this.val = stream.getValue();
        }
    }
    public List<Integer> getNumberInAtLeastKStream(List<Stream> lists, int k){
        List<Integer> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) return res;

        PriorityQueue<Num> minHeap = new PriorityQueue<>(new Comparator<Num>() {
            @Override
            public int compare(Num o1, Num o2) {
                return o1.val - o2.val;
            }
        });

        //先把所有的stream放进heap里面, 每个stream都把第一个数加进去
        for (Stream s: lists) {
            if (s.move()){ //这里先判断一下要不就崩了
                minHeap.offer(new Num(s));
            }
        }

        while (!minHeap.isEmpty()){
            Num cur = minHeap.poll();
            int curValue = cur.val;
            int count = 1;
            while (cur.stream.move()){    // 把第一个stream的所有数加入minHeap，但加入时每个数只加入一次，重复不加
                int nextVal = cur.stream.getValue();
                if (nextVal == curValue){
                    continue;
                } else {
                    cur.val = nextVal;
                    minHeap.offer(cur);
                    break;
                }
            }
            //更新其他stream的头部，就是把指针往后挪，相同的数字就计数了。
            while (!minHeap.isEmpty() && curValue == minHeap.peek().val){
                count++;
                Num num = minHeap.poll();
//                int numVal = num.val;

                while (num.stream.move()){
                    int nextVal = num.stream.getValue();
                    if (curValue == nextVal){
                        continue;
                    }
                    else {
                        num.val = nextVal;
                        minHeap.offer(num);
                        break;
                    }
                }
            }
            if (count >= k){
                res.add(curValue);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        MergeKSortedStreams test = new MergeKSortedStreams();
        Integer[] arr1 = {1,2,3,4};
        Integer[] arr2 = {2,5,6};
        Integer[] arr3 = {2,5,7};

        List<Integer> l1 = Arrays.asList(arr1);
        List<Integer> l2 = Arrays.asList(arr2);
        List<Integer> l3 = Arrays.asList(arr3);

        List<Stream> lists = new ArrayList<>();
        lists.add(new Stream(l1));
        lists.add(new Stream(l2));
        lists.add(new Stream(l3));

        List<Integer> res = test.getNumberInAtLeastKStream(lists, 2);
        System.out.println(res);
    }
}
