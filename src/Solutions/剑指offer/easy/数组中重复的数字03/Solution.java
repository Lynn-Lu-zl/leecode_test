package Solutions.剑指offer.easy.数组中重复的数字03;


import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 先排序后查找
     * 时间：O(nlogn)-->排序的复杂度
     * 空间：O(1)
     * @param nums
     * @return
     */
    // public int findRepeatNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] == nums[i + 1]) {
    //             return nums[i];
    //         }
    //
    //     }
    //     //遍历完都没有重复值，则返回 -1
    //     return -1;
    // }

    /**hashset
     * 时间复杂度 O(N) ： 遍历数组使用 O(N)O(N) ，HashSet 添加与查找元素皆为 O(1)O(1) 。
     * 空间复杂度 O(N) ： HashSet 占用 O(N)O(N) 大小的额外空间。
     * @param nums
     * @return
     */
    // public int findRepeatNumber(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         if (set.contains(num)) {
    //             return num;
    //         }
    //         set.add(num);
    //     }
    //     return -1;
    // }

    /**
     * 原地置换
     * 每个人都有自己的位置，我们需要和别人调换回到属于自己的位置，调换之后，如果发现我们的位置上有人了，则返回
     *
     *
     * 2, 3, 1, 0, 2, 5, 3
     * 0  1  2  3  4  5  6
     *
     *
     * num[0]=2
     * num[num[0]]=num[2]=1
     * 两个值不等--》交换位置-->让2换到num[2]-->保持索引和索引对应的值一样
     * num[0]=2 换到 temp=2
     * nums[temp]=nums[2] 换到 num[0]
     * temp=2 换到 nums[temp]=num[2]
     *
     * 这时num[2]的值已经是2了
     * 如果发现后面还有num[2] =num[i]->多个元素对应同一个下标说明是重复值--》直接返回
     *
     *时间复杂度 O(N) ： 遍历数组使用 O(N)O(N) ，每轮遍历的判断和交换操作使用 O(1)O(1) 。
     * 空间复杂度 O(1) ： 使用常数复杂度的额外空间

     * @param
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        if (nums.length==0){
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                //交换
                int temp = nums[i];
                //已经把nums[i]给=赋值temp了
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        //遍历完都没有重复值，则返回 -1−1
        return -1;
    }


     public static void main(String[] args) {

         int[] ints = {3,4,2,1,1,0};
         Solution solution = new Solution();
         System.out.println(solution.findRepeatNumber(ints));
     }
}
