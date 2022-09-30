package Solutions.middle;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length <3){
            return 0;
        }
        //排序
        Arrays.sort(nums);
        int res =nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            //{-4,-1,-1,0,1,2}--》[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
            //相邻索引值重复导致重复结果集去重，直接进入下一次循环
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //左指针永远在i的后一位
            int left = i+1;
            //右指针在数组最右边
            int right = nums.length-1;
            while (left < right){
                //记录三数之和
                int sum = nums[i] + nums[left] + nums[right];
                // 根据差值的绝对值来更新答案
                if (Math.abs(target-sum) < Math.abs(target-res)) {
                    res = sum;
                }
                if (sum < target){
                    left ++;
                }else if (sum > target){
                    right --;
                }else {
                    return target;
                }
            }
        }
        return res;


        // Arrays.sort(nums);
        // int ans = nums[0] + nums[1] + nums[2];
        // for(int i=0;i<nums.length;i++) {
        //     int start = i+1, end = nums.length - 1;
        //     while(start < end) {
        //         int sum = nums[start] + nums[end] + nums[i];
        //         if(Math.abs(target - sum) < Math.abs(target - ans))
        //             ans = sum;
        //         if(sum > target)
        //             end--;
        //         else if(sum < target)
        //             start++;
        //         else
        //             return ans;
        //     }
        // }
        // return ans;
    }
     public static void main(String[] args) {

         Solution16 solution16 = new Solution16();
         int[] ints = {-1,2,1,-4};
         int target = 1;
         System.out.println(solution16.threeSumClosest(ints, target));
     }
}
