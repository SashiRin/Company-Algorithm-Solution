package houzz;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : SortColors
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class SortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length-1;
        int index = 0;
        while (index <= right) { // just consider (1,0) to decide whether index < right
            if (nums[index] == 0) {
                swap(nums, index++, left++);
            } else if(nums[index] == 1) {
                index++;
            } else {
                swap(nums, index, right);
                right--;
            }
        }
    }
    private void swap(int[] nums, int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
