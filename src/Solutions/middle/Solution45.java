package Solutions.middle;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 */
public class Solution45 {

    /**
     * 类比加油站加油
     *
     * 一辆汽车从下标0处开始出发，每个下标上的值表示它在该位置加油后能够走的距离，最少加几次油能到达终点。
     *
     * 官方题解中的两个变量：边界 end、最远下标 maxPosition，可以理解为：
     *
     * 边界 end：如果汽车在中途不加油，最远只能行驶到 end 这个位置，到了这个位置，就必须要加油，不然没法继续前进
     * 最远下标 maxPosition：如果汽车在中途某个位置 i 处加一次油，最远能跑到的位置
     * 这样，汽车从起点开始出发，路过每一个加油点，不断计算着自己的 end 和 maxPosition，整个过程如下：
     *
     * 在到达 end 之前中途不加油，直到 end 才加油，加油次数加1
     * 在到达 end 之前，在途中下标 ii 处加了一次油，到了 end 不需要加油，加油次数也要加1，这个算的是下标 ii 处的那一次加油，并且 end 变成 maxPosition，表示在下标 ii 处加油后能够到达 maxPosition
     * 越过第一个 end 之后，汽车重复前面步骤，最终到达终点
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int n = nums.length, maxPosition = nums[0], end = nums[0], step = 1;
        for (int i = 1; i < n - 1; i++) {
            // 不断计算 maxPosition
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 到达边界，必须加一次油，或者在前面某个下标处加过一次油
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

     public static void main(String[] args) {

         Solution45 solution45 = new Solution45();
         int[] ints = {2, 3, 0, 1, 4};
         System.out.println(solution45.jump(ints));
     }

}
