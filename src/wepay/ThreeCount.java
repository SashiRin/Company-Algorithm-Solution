package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ThreeCount
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ThreeCount {
    /*
    如果一个自数组和是三的倍数 sum[i...j] = sum[0...j]-sum[0...i-1]  那么 sum[0...i-1] 和 sum[0...j]
    应该是对于3同余的 所以可以用三个count0 count1 count2 分别代表除以3余0 1 2 的个数，然后 遍历一遍 当计算从0到当前的和
    假如余2 那么 它可以和他前面所有的余2的sum分别组成一个unique的子数组 所以result+=count2 最后得出结果 O(n)
     */
    public int subCount(int[]nums,int k){
        int n = nums.length;
        int []cnt=new int[k];
        int cntNum=0,sum=0;
        for(int i=0;i<n;++i){
            sum+=nums[i];
            int rem = sum%k;
            if(rem==0){
                cntNum+=++cnt[0];
            }else{
                cntNum+=cnt[rem];
                cnt[rem]++;
            }
        }
        return cntNum;
    }
}
