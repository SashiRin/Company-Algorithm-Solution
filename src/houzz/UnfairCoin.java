package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : UnfairCoin
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class UnfairCoin {
    /*
    一个unfair coin，怎么disign一个process可以返回同样几率的0和1
    解： 投出0，1的概率和1，0的概率是一样的，但可以顺序不同，所以01，10各是50%，投出11，00，再投，直到出现01，10为止
     */
    public int foo() // given method that returns 0 with 60% probability and 1 with 40%
    {
        // some code here
        return 1;
    }
    int my_fun()
    {
        int val1 = foo();
        int val2 = foo();
        if (val1 == 0 && val2 == 1)
            return 0;   // Will reach here with 0.24 probability
        if (val1 == 1 && val2 == 0)
            return 1;   // // Will reach here with 0.24 probability
        return my_fun();  // will reach here with (1 - 0.24 - 0.24) probability
    }
}
