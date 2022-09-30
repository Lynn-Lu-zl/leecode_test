package Solutions.middle;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class Solution55 {
    // public boolean canJump(int[] nums) {
    //
    //     int k = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if (i > k){
    //             return false;
    //         }
    //         k = Math.max(k,i+nums[i]);
    //     }
    //     return true;
    // }

    /**贪心算法
     * 时间O(N),空间O1
     * 不用拘泥于每次究竟跳跳几步，而是看覆盖范围，覆盖范围内一定是可以跳过来的，不用管是怎么跳的。
     * 不用考虑每一步跳跃到那个位置，而是尽可能的跳跃到最远的位置，看最多能覆盖的位置，不断更新能覆盖的距离。
     *
     * i每次移动只能在cover的范围内移动，每移动一个元素，cover得到该元素数值（新的覆盖范围）的补充，让i继续移动下去。
     *
     * 而cover每次只取 max(该元素数值补充后的范围, cover本身范围)。
     *
     * 如果cover大于等于了终点下标，直接return true就可以了。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {

        //长度为1，直接就是终点
       if (nums.length == 1) return true;
       //保存当前所能到达的最远距离(即第i个位置所能到达的最远距离)
       int cover = 0;
       //遍历数组
        for (int i = 0; i <= cover; i++) {
            //更新最远距离
            cover = Math.max(cover,i+nums[i]);
            //说明可以跳到最后一格了
            if (cover >= nums.length -1){
                return true;
            }

        }
        return false;
    }

     public static void main(String[] args) {
         Solution55 solution55 = new Solution55();
         int[] ints = {3,2,1,0,4};

         System.out.println(solution55.canJump(ints));
     }
}
