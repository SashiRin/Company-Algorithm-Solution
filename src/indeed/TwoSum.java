package indeed;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : indeed
 * File Name : TwoSum
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] index=new int[2];
        int start=0,end=numbers.length-1;
        while(start<end){
            int sum=numbers[start]+numbers[end];
            if(sum==target){
                index[0]=start+1;
                index[1]=end+1;
                break;
            }else if(sum<target){
                start++;
            }else{
                end--;
            }
        }
        return index;
    }

}
