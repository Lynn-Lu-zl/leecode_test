package Solutions.easy;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 *
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 */
public class Solution88 {
    /**
     * 重点：
     * 两个数组有序；
     * 合并结果放到 nums1 中
     *
     *
     * 头号玩家，一直后退才是最好的
     * 如果两个数组从结尾向开头（数字从大到小）进行比较，那么每次把比较之后的数字放置到 nums1 中的后面，由于后面的数字本身就是提供出来的多余的位置，都是 0，因此不需要对 nums1 进行移动
     *
     *
     * 从后向前比较
     *
     * 当 m > 0 并且 n > 0 时，从后向前比较 num1[m - 1] 和 nums2[n - 1] ：
     * 如果是 nums1[m - 1] 大，则把 nums1[m - 1]放到 num1 的第 m + n - 1位置，并让 m -= 1
     * 如果是 nums1[n - 1] 大，则把 nums2[n - 1] 放到 num1 的第 m + n - 1位置，并让 n -= 1
     * 当上面的遍历条件结束的时候，此时 m 和 n 至少有一个为 0。
     * 当 m == 0 时，说明 num1 的数字恰好用完了，此时 nums2 可能还剩元素，需要复制到 nums1 的头部；
     * 当 n == 0 时，说明 num2 的数字恰好用完了，此时 nums1 可能还剩元素，由于剩余的这些元素一定是 nums1 和 nums2 中最小的元素，所以不用动，直接留在原地就行。
     *
     *时间复杂度：O(M + N)
     * 空间复杂度：O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */


    /**
     * 直接合并后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     for (int i = 0; i != n; ++i) {
    //         nums1[m + i] = nums2[i];
    //     }
    //     Arrays.sort(nums1);
    // }

    /**
     * 递归法，类似21题
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0){
            return;

        } else if (m!= 0 && nums1[m-1] >= nums2[n-1]) {
            //
            nums1[m+n-1] = nums1[m-1];
            merge(nums1,m-1,nums2,n);

        } else {
            //
            nums1[m+n-1] = nums2[n-1];
            merge(nums1,m,nums2,n-1);
        }
    }


     public static void main(String[] args) {
         Solution88 solution88 = new Solution88();
         int[] nums1 = {1, 2, 3, 0, 0, 0};
         int[] nums2 = {2,5,6};
         int m=3;
         int n=3;
         solution88.merge(nums1,m,nums2,n);
     }
}
