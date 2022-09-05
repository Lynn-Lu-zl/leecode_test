package Solutions.easy;
/**1、两数之和;给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

        你可以按任意顺序返回答案

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/two-sum
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/



import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        //法一暴力解法，枚举
        // for (int i = 0; i < nums.length-1; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if(nums[i]+nums[j]==target){
        //             return new int[] {i,j};
        //         }
        //     }
        // }

        //哈希映射
        // 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
        // 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
        // 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
        //         如果最终都没有结果则抛出异常
        //
        // 作者：guanpengchn
        // 链接：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
        // 来源：力扣（LeetCode）
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

        //最好写成这样：Map<Integer,Integer> map = new HashMap<>();让你的程序会更灵活。当你决定更换实现的时候，所要做的就只是：改变构造器中类的名称，后面想改TreeMap类型的时候只需要改HashMap()就行了，不用把前面的HashMap<Integer,Integer>都改了
        //用接口引用对象会使程序更加灵活
        HashMap<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            //如果集合包含这个键，返回这个键
            //     判断集合中是否含有这个值containsValue(Object value)
            //     判断集合中是否含有这个键    containsKey(Object key)
            if (map.containsKey(target-nums[i])){
                //map的获取方法， get(Object key) 只获取键，因为有了键就会映射到值

                return new int[] {map.get(target-nums[i]),i};
            }
            //否则存入这个键值对到集合中，继续遍历
            map.put(nums[i], i);
        }
        return null;

    }
    
    
     public static void main(String[] args) {
         int[] nums1={2,7,11,15};
         int[] twoSum1 = new Solution1().twoSum(nums1, 26);
         System.out.println(Arrays.toString(twoSum1) );


     }

}

