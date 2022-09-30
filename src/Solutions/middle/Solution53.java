package Solutions.middle;

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
    /**
     *
     * 动态规划
     * 当前最大子序和只和前面的子序和相关，循环数组，不断更新最大子序和
     * 复杂度：时间复杂度O(n)，空间复杂度O(1)
     * @param nums
     * @return
     */
    // public int maxSubArray(int[] nums) {
    //     //最大和,初始化为一个元素，如果数组只有一个元素，那么最大和就是本身
    //     int maxSum = nums[0];
    //     int temp=0;
    //     for (int num : nums) {
    //         //遍历数组，temp + num记录了前n个元素的最大和，和当前元素作比较--》遍历的当前元素就已经比你前面的n个元素最大和要大那就丢弃之前的最大和，从当前元素开始重新计算最大子序和
    //         temp = Math.max(temp + num,num);
    //         //更新最大和
    //         maxSum = Math.max(maxSum,temp);
    //     }
    //     return maxSum;
    // }

    /**
     * 用一个变量sum保存和,若sum小于0,则抛弃之前的和,令sum等于当前遍历到的匀元素,
     * 若sum大于0,则继续累加和,每遍历一个数，就将ans更新为当前最大和
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        //记录最大值
        int maxSum = nums[0];
        //当前累计和最大值
        int temp = 0;
        //遍历，如果当前累计和小于0则丢弃，因为负数加上任何其他数据都是拉低数值的
        for(int num:nums){
            if(temp < 0){
                //从新开始计算最大和
                temp  = num;
            }
            else{
                //当前累加和大于0则记录累加
                temp +=num;
            }
            //更新记录最大值
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
