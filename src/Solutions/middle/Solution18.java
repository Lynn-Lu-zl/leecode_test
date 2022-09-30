package Solutions.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 4){
            return list;
        }

        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //
            // if (nums[i] > target ){
            //     return list;
            // }
            //{-4,-1,-1,0,1,2}--》[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
            //i索引：相邻索引值重复导致重复结果集去重，直接进入下一次循环
            //注意i是从0开始的，所以>0
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for (int j = i+1; j < nums.length; j++) {
                //左指针永远在j的后一位
                int left = j+1;
                //右指针在数组最右边
                int right = nums.length-1;

                //和上面的i索引去重一样，相邻索引值重复导致重复结果集去重，直接进入下一次循环
                //注意j是从i+1开始的，所以j>i+1
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                while (left < right){
                    //记录三数之和
                    //{1000000000,1000000000,1000000000,1000000000};防止int越界，转为long
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum < target ){
                        left ++;
                    }else if (sum > target){
                        right --;
                    }else if (sum == target){
                        //三数之和为0添加到集合list
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        //如：{-2,0,0,2,2};--》[[-2, 0, 2], [-2, 0, 2]]
                        //排除相同顺序相同元素的结果，左指针相邻的相同值去重
                        while (left < right && nums[left] == nums[left+1]){
                            left++;
                        }
                        //排除相同顺序相同元素的结果，右指针相邻的相同值去重
                        while (left < right && nums[right] == nums[right-1]){
                            right--;
                        }
                        //左右指针都往中间靠，继续找三数之和=0的组合
                        left ++;
                        right --;
                    }
                }
            }


        }
        return list;
    }
     public static void main(String[] args) {
         Solution18 solution18 = new Solution18();
         // int[] ints = {2,2,2,2,2};
         // int target = 8;
         // int[] ints = {1,0,-1,0,-2,2};
         // int target = 0;

         // int[] ints = {1,-2,-5,4,-3,3,3,5};
         // int target = -11;

         int[] ints = {1000000000,1000000000,1000000000,1000000000};
         int target = -294967296;

         System.out.println(solution18.fourSum(ints, target));
     }
}
