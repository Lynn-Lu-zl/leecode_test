package Method.优先队列;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution215 {
    /**
     * 堆的大小不会超过 k，所以插入和删除元素的复杂度是 O(logK)，再套一层 for 循环，
     * 总的时间复杂度就是 O(NlogK)
     *
     * 遍历数组
     * 将元素加入到堆中，if堆的大小大于k时就开始将堆顶元素弹出，加入新的，这样就能保证堆顶元素就是第k个大的元素，
     * 因为在堆顶下面的元素一定是第k-n个大的元素，就像k=2，堆就两个元素，6最大，只要加入到堆后它就一直压在堆底，它就是第k-1=2-1大的，而
     * 当堆大小超过 k 的时候，我们就删掉堆顶的元素
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return nums[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            //都先加进来再比较
            queue.add(nums[i]);
            if (queue.size() > k){
                queue.poll();
            }
        }

        return queue.peek();
    }
     public static void main(String[] args) {
         Solution215 solution215 = new Solution215();
         int[] ints = {3, 2, 1, 5, 6, 4};
         int k =2;
         System.out.println(solution215.findKthLargest(ints, k));
     }
}
