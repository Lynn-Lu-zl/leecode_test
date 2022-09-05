package Solutions.easy;

/**27、移除元素
 *给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution27 {

    public int removeElement(int[] nums, int val) {

        /**
         * 侦察兵双指针
         *
         * 慢指针 slow：数组下标从0开始，用于搜索需要删除的值，当遇到需要删除的值时，慢指针直接跳过，后面的指针不动，
         * 快指针 fast：数组下标从0开始，当遇到不需要删除的值时，两个指针都进行移动，并修改慢指针的值。最后只需输出慢指针的索引即可。因为有可能遍历到数组下标为0的第一个元素就为val，如果从1可能会忽略了nums[0]也为val的情况
         * for循环遍历数组nums
         * 判断条件：
         *      nums[fast] 不等于 val ：慢指针
         *
         */
        //判断数组为空的情况
        if (nums==null || nums.length==0){
            return 0;
        }
        int slow=0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;


        /**
         * 增强循环+双指针
         */
       // int slow=0;
       //  for (int num : nums) {
       //      if (num != val){
       //         nums[slow++] = num;
       //      }
       //  }
       //  return slow;
    }

     public static void main(String[] args) {
         Solution27 solution27 = new Solution27();
         //int[] nums={0,1,2,2,3,0,4,2};
         //空数组，报空指针异常NullPointerException
         //int[] nums=null;
         //数组长度为0，不报异常，返回0
         //int[] nums={};
         int[] nums=new int[0];
         //移除数组中为2的值
         int val=2;
         System.out.println("移除所有val值后数组的新长度:"+ solution27.removeElement(nums, val));
         int len = solution27.removeElement(nums, val);
         for (int i = 0; i < len; i++) {
             //移除val后的新数组
             System.out.println(nums[i]);
         }

     }
}
