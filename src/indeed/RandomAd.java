package indeed;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : RandomAd
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class RandomAd {
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
