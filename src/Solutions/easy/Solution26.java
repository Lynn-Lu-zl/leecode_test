package Solutions.easy;

/**
 * 26、删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 要做两件事，新数组=删除重复元素并计算新长度+修改数组
 * 删除重复元素：实际上就是将不重复的元素移到数组的左侧
 * 对数组重新赋值=删除操作
 */
public class Solution26 {


    public int removeDuplicates(int[] nums) {

        /**
         * 双指针/快慢指针
         * 慢指针 slow：数组下标从0开始
         * 快指针 fast：数组下标从1开始
         * for循环遍历数组nums
         * 判断条件：
         *      nums[slow] 不等于 nums[fast]: 慢指针slow右移1位，nums[fast]赋值给nums[slow]
         *      nums[slow] 等于 nums[fast]: 不用操作继续遍历
         * 循环结束，slow慢指针的值+1=无重复数组的长度（慢指针slow从0开始，新数组长度为3的slow为2，所以+1）,
         *
         *时间复杂度：O(n)，其中 n是数组的长度。快指针和慢指针最多各移动 n次
         * 空间复杂度：O(1)。只需要使用常数的额外空间。
         */

        if (nums==null || nums.length==0){
            return 0;
        }
        int slow=0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]){
                slow++;
                nums[slow]=nums[fast];
            }
        }
        return slow+1;

    }

     public static void main(String[] args) {
         Solution26 solution26 = new Solution26();
         int[] nums={0,0,1,1,1,2,2,3,3,4};
         //返回删除后数组的新长度
         System.out.println("删除重复项后数组的新长度:"+ solution26.removeDuplicates(nums));
         int len = solution26.removeDuplicates(nums);
         for (int i = 0; i < len; i++) {
             //无重复值的数组
             System.out.println(nums[i]);
         }
     }
}
