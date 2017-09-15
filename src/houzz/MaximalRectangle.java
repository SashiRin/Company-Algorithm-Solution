package houzz;

import java.util.Stack;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : houzz
 * File Name : MaximalRectangle
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] heights = new int[n + 1];//height[j]:the num of "1" in j col from currRow to the top "0"/top boundary
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < n + 1; j++) {
                if (j < n && matrix[i][j] == '1') {
                    heights[j] += 1;//update the height that expand from curr row to the top '1'
                } else {//which means the last num(heights[n]) is always 0; and if j < n but it's not '1', it should be 0 too
                    heights[j] = 0;
                }

                //each loops we calculate the area of rectangle that ends at curr j, loops until the top is less than curr j
                //each num only goes in&out stack once,so this is O(1) time
                //if curr height <= peek(),calculate the max area, and update left bound by poping out the top
                while (!stack.empty() && heights[j] <= heights[stack.peek()]) {
                    int height = heights[stack.pop()];
                    int width = j;//if stack is empty,it means the width of curr rectangle starts from leftmost(0) to curr j
                    if (!stack.empty()) {//if stack isn't empty,it means the width of curr rectangle starts from peek() to j
                        width = width - stack.peek() - 1;
                    }
                    max = Math.max(max, height * width);//update the max rectangle
                }
                stack.push(j);//remember to push j !!!
            }
        }
        return max;

    }
}
