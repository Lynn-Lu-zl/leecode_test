package Method.数组;

/**
 *53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int maxSum = nums[0];
        int temp = 0;
        for (int num : nums) {
            //说明相加之后的连续和是递增，不是递减
            if (num + temp > num){
                //更新当前连续和的值
                temp += num;
            }else {
                //如果是递减我就重新开始
                temp = num;
            }
            maxSum = Math.max(maxSum,temp);
        }

        return maxSum;
    }




     public static void main(String[] args) {

         Solution53 solution53 = new Solution53();
         int[] ints = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
         System.out.println(solution53.maxSubArray(ints));
     }
}
