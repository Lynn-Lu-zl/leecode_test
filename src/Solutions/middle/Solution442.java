package Solutions.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 442. 数组中重复的数据
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-duplicates-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution442 {

    // public List<Integer> findDuplicates(int[] nums) {
    //     ArrayList<Integer> list = new ArrayList<>();
    //     if (nums.length == 0){
    //         return list;
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if (nums[i] > 0 && nums[i] != i + 1) {
    //             int j = nums[i] - 1;
    //             if (nums[i] == nums[j]) {
    //                 list.add(nums[i]);
    //                 nums[i]=0;
    //             } else {
    //                 int temp = nums[i];
    //                 nums[i] = nums[j];
    //                 nums[j] = temp;
    //             }
    //         }
    //
    //     }
    //         return list;
    // }

    /**
     * 遍历到的值都取相反数，如果是
     * @param nums
     * @return
     */
    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> list = new ArrayList<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         //题目中的关键提示 nums所有整数范围都在[1,n]之间
    //         //所以可以用每个数字出现后把对应下标-1的数字置为相反数（之所以减1是数组从0开始）
    //         //那么重复出现的数字就会在第二次访问的时候发现原来的数字变成相反数了。
    //         //之所以是相反数是因为后面入遍历到这个数字的时候还需要修改他对应位置的数（加绝对值就可以，不会造成丢失）
    //
    //         //(a < 0) ? -a : a;
    //         int num = Math.abs(nums[i]);
    //         if (nums[num - 1] > 0) {
    //             //把num-1位置上的数字置为相反数
    //             nums[num - 1] = - nums[num - 1];
    //         } else {
    //             //如果该位置的数是负数，则是第二次访问这个数，下标出现了两次记录
    //             list.add(num);
    //         }
    //     }
    //     return list;
    // }


    // public List<Integer> findDuplicates(int[] nums) {
    //     List<Integer> res = new ArrayList<>();
    //     for(int i=0;i<nums.length;i++){
    //         int index = Math.abs(nums[i])-1;
    //         if(nums[index]>0){
    //             nums[index] *= -1;
    //         }else{
    //             res.add(index+1);
    //         }
    //     }
    //     return res;
    // }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                list.add(nums[i]);
            }
        }
        return list;
    }




     public static void main(String[] args) {
         Solution442 solution442 = new Solution442();
         // int[] ints = {5,4,6,7,9,3,10,9,5,6};
         int[] ints = {1,3,2,1};
         List<Integer> duplicates = solution442.findDuplicates(ints);
         System.out.println(duplicates);


     }
}
