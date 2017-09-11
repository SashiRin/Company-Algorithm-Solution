package houzz;

import java.util.Random;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : RandomIntegerStream
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class RandomIntegerStream {
    /**
     * 题目是有一个integer stream, 不知道到底多少个，然后输出随机 k 个sample。
     * 要求每个元素sample 到的概率完全一样。内存不能用太多并且和performance 要好
     */

    private static int[] res;
    private static Random rmd;
    private static int size;
    private static int k;

    public RandomIntegerStream(int k){
        res = new int[k];
        rmd = new Random();
        size = 0;
        this.k = k;
    }

    public static int[] next(int val) {
        if (size < k) {   //因为是随机k个，所以size一定会大于k，所以下面的for循环肯定成立
            res[size] = val;
        }
        size++;
        /*
        for (int i = k; i < size; i++) {
            // Pick a random index from 0 to i.
            int j = rmd.nextInt(i + 1);
            if (j < k) {
                // 这里因为是输入的stream，我们不能开辟新的stream把每个val都传入，只知道当前的，该怎么写？?
                res[j] = stream[i];
            }
        }*/
        //这是我的想法，应该对把？？
        int random = rmd.nextInt(size + 1);
        if (random < k) {
            res[random] = val;
        }
        return res;
    }
}
