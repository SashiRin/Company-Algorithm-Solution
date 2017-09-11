package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : CountTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class CountThree {
    /*
    Count number of 3 given n (E.x: given 30, return 4 {3,13, 23, 30})
     */
    public static int countThree(int num) {
        int count = 0 ; // Initialize result

        // n
        for (int i=3; i <= num; i++)
            count += number0f3s(i);

        return count;
    }
    public static int number0f3s(int n)
    {
        int count = 0;
        while (n > 0)
        {
            if (n % 10 == 3)
                count++;

            n = n/10;
        }
        return count;
    }
}
