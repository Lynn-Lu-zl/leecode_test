package Solutions.easy;

/**
 * 485. 最大连续 1 的个数
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1.
 *
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 *
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2

 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution485 {
    /**
     * 直接计数再比较最大值
     * 通过计数器计数 连续 1 的个数，
     * 当 nums[i] == 1 时，count++，
     * 当nums[i] 为 0 时，则先保存最大 count为maxcount，再将 count 清零，因为我们需要的是连续的 1 的个数，所以需要清零
     * 退出循环比较一次最大值（是最后一个0后面连续的 1 的个数大还是之前的maxcount个数大），并返回结果
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null|| nums.length == 0){
            return 0;
        }

        int count=0;
        int maxcount=0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1)
            {
                count++;
            }
            else if (nums[i] == 0)
            {
                maxcount = Math.max(maxcount, count);
                count = 0;
            }
        }
        int result=Math.max(maxcount, count);
        return result;
    }
     public static void main(String[] args) {
         Solution485 solution485 = new Solution485();
         int[] nums = {1,0,1,1,0,1};
         System.out.println(solution485.findMaxConsecutiveOnes(nums));
     }
}
