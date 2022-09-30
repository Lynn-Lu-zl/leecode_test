package Solutions.middle;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 *
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 *
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 */
public class Solution287 {
    /**
     * 其数字都在 [1, n] 范围内（包括 1 和 n）
     * 我们需要快慢指针，同时从起点出发，慢指针一次走一步，快指针一次走两步，然后记录快慢指针相遇的点。
     *
     * 之后再用两个指针，一个指针从起点出发，一个指针从相遇点出发，当他们再次相遇的时候就是入口点了。
     *
     * 举例 3 1 3 4 2
     *  索引0 1 2 3 4
     *
     * 首先 第一个元素下标0， 对应值为3，认为它是next
     *     0 -> 3  , 然后找到 3索引的值4，循环往复得到
     *  0 -> 3 - >4 ->2 -> 3
     * @param nums
     * @return
     */
    // public int findDuplicate(int[] nums) {
    //     int slow = nums[0];
    //     int fast = nums[nums[0]];
    //     //寻找相遇点
    //     while (slow != fast) {
    //         slow = nums[slow];
    //         fast = nums[nums[fast]];
    //     }
    //     //slow 从起点出发, fast 从相遇点出发, 一次走一步
    //     slow = 0;
    //     while (slow != fast) {
    //         slow = nums[slow];
    //         fast = nums[fast];
    //     }
    //     return slow;
    // }

    public int findDuplicate(int[] nums) {

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     //如果key存在，直接返回该元素
        //     if (map.containsKey(nums[i])){
        //         return nums[i];
        //     }else{
        //         //如果key不存在，说明不重复，放入map中
        //         map.put(nums[i],0);
        //     }
        // }
        // return -1;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (! set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return nums[i];
            }
        }
        return -1;
    }

    /***
     *
     * @param args
     */

    public static void main(String[] args) {
         Solution287 solution287 = new Solution287();
         int[] ints = {3, 1, 3, 4, 2};
         System.out.println(solution287.findDuplicate(ints));
     }
}
