package indeed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : ExpiringMap
 * Creator : Edward
 * Date : Sep, 2017
 * Description : 多线程怎么回答！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！以后要写上
 */


public class ExpiringMap<K, V> extends TimerTask {
    /*
    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=292633&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D26%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    设计一个map，put的时候除了key value同时还有一个timeout，get的时候如果这个value的timeout过了就得返回null
    写一个类似于hashmap的结构，其中除了传统的key和value之外另加了一个duration。 要求实现的功能是说讲一个数据存入此Map后，
    在duration的时间范围内call get function可以得出相应的value。但是一但超出duration的这个时间，再call get function就只能返回 nul

    put(10, 35, 3000)；
    //在3000 毫秒以内：
    get(10) --> return 35;
    //超出3000毫秒：
    get(10) --> return null;
     */
    // fields
    class Node<K, V> {
        // fields
        private K key;
        private V value;
        private long duration;
        private long startTime;

        // methods
        public Node (V value, long duration, long startTime) {
            this.value = value;
            this.duration = duration;
            this.startTime = startTime;
        }
    }

    private LinkedList<Node> list;
    HashMap<K, Node> map;

    public ExpiringMap(){
        map = new HashMap<>();
        list = new LinkedList<>();
    }



    public void put(K key, V value, long duration) {
        long startTime = System.currentTimeMillis();
        Node node = new Node(value, duration, startTime);
        map.put(key, node);
        checkTime();
        addToHead(value, duration, startTime);
    }

    public V get(K key) {
        checkTime();
        if (map.containsKey(key)) {
            Node node = map.get(key);
            return (V) node.value;
        } else {
            return null;
        }
    }

    public void checkTime() {
        long curTime = System.currentTimeMillis();
        while (!list.isEmpty()) {
            Node node = list.getLast();
            if (node.duration + node.startTime > curTime) {
                list.removeLast();
                map.remove(node.key);
            } else {
                break;
            }
        }
    }
    public void addToHead(V value, long duration, long startTime) {
        Node node = new Node(value, duration, startTime);
        list.addFirst(node);
    }

    @Override
    public void run() {
        checkTime();
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        ExpiringMap expiringMap = new ExpiringMap();
        timer.schedule(expiringMap,0,1000);//1000毫秒检查一次
    }
}
