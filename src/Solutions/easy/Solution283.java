package Solutions.easy;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 *
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 *
 * 输入: nums = [0]
 * 输出: [0]
 *  
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution283 {
    public int[] moveZeroes(int[] nums) {

        /**
         * 二次循环，单指针
         */
        //移动元素的索引，可以看做是一个新数组的索引
        int index=0;
        //第一次循环：将非0的元素移动到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
            {
                nums[index] = nums[i];
                index++;
            }


        }
        //第二次循环：填充0/将为0的元素移动到后面，第一次循环后数组元素都不为0，将当前移动元素的索引index赋值给movezero，按index顺序继续遍历数组将剩余的空间填充0
        for (int movezero = index; movezero < nums.length; movezero++) {
            nums[movezero] = 0;
        }
        return nums;
    }

     public static void main(String[] args) {
         Solution283 solution283 = new Solution283();
         int[] nums = {0,1,0,3,12};
         System.out.println(Arrays.toString(solution283.moveZeroes(nums)));
     }
}
