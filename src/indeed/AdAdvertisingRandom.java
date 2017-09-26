package indeed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : AdAdvertising
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class AdAdvertisingRandom<V> {
    /**
     * 给你一个List 里面有ads，然后写一个get（） function，来随机get一个list里面的ad，不能重复，而且get 完了后 return null
     */
    private ArrayList<V> arr;
    private int length;
    Random rmd;

    public AdAdvertisingRandom(List<V> list) {
        rmd = new Random();
        arr = new ArrayList<>(list);
        length = arr.size();
    }

    public V get() {
        int random = rmd.nextInt(length--);
        V ad = arr.get(random);
        V last = arr.get(arr.size() - 1);
        arr.set(random, last);
        arr.set(arr.size() - 1, ad);
        return null;
    }
    //就是给你一个List 里面有ads，然后写一个get（） function，来随机get一个list里面的ad，不能重复，而且get 完了后 return null。
    public Integer getRandom(List<Integer> list) {
        Random rmd = new Random();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }
        int random = rmd.nextInt(list.size());
        int val = list.get(random);
        int index = map.remove(val);
        int lastVal = list.remove(list.size() - 1);
        if (index != list.size()) {
            list.set(index, lastVal);
            map.put(lastVal, index);
        }
        return null;
    }
}
