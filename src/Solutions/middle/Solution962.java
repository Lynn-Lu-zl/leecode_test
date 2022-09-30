package Solutions.middle;

import java.util.Stack;

/**
 *
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 *
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 示例 2：
 *
 * 输入：[9,8,1,0,1,9,4,0,4,1]
 * 输出：7
 * 解释：
 * 最大宽度的坡为 (i, j) = (2, 9): A[2] = 1 且 A[9] = 1.
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 *
 */
public class Solution962 {

    /**
     * 单调栈
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int max = 0;

        // 存储从0到n的严格递减序列，栈顶是栈中最小的数
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]){
                stack.push(i);
            }
        }

        for (int j = nums.length-1; j >=0 ; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]){
                int temp =stack.pop();
                max = Math.max(max,j-temp);
            }
        }
        return max;
    }


     public static void main(String[] args) {
         Solution962 solution962 = new Solution962();
         int[] ints = {6, 0, 8, 2, 1, 5};
         System.out.println(solution962.maxWidthRamp(ints));
     }

}
