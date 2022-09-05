package Solutions.easy;

import java.util.Arrays;

/**
 * 217、存在重复元素
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        /**
         * 排序法： 先对数组排序，遍历数组（3个元素只需要遍历2次，循环次数为nums.length-1，否则会有数组下标越界异常）,重复数据必然相邻，判断相邻元素是否相等
         *
         */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;



        /**
         * 哈希表：遍历数组，数字放到 set 中
         * 判断set集合是否存在遍历的数字num，如果数字已经存在于 set 中，直接返回 true
         * 如果成功遍历完数组，则表示没有重复元素，返回 false
         */

    //     Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //         //如果遍历到的数字num包含在set集合中，存在重复元素
    //         if (set.contains(num)){
    //             return true;
    //         }
    //         //将遍历到的数字num添加到set集合
    //          set.add(num);
    //     }
    //     return false;
    // }

        /**
         * 哈希表
         * set集合不允许有重复值，如果遍历到的num已经存在了无法进行增加操作，返回false，
         * !set.add(num)返回true，表示有重复值
         */
    // Set<Integer> set = new HashSet<>();
    //     for (int num : nums) {
    //     if (!set.add(num)){
    //         return true;
    //     }
    // }
    //     return false;
}

     public static void main(String[] args) {
         Solution217 solution217 = new Solution217();
         int[] nums={2,1};
         System.out.println(solution217.containsDuplicate(nums));
     }
}
