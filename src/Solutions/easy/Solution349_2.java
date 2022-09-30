package Solutions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution349_2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0){
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();


        //首次遍历，先把每个数记录出现次数
        for (int aNums1 : nums1) {
            if (map.containsKey(aNums1)) {
                //已经出现过的键对应的值次数+1
                map.put(aNums1, map.get(aNums1) + 1);
            } else {
                //没出现过的添加键到map集合，次数初始化为1
                map.put(aNums1, 1);
            }
        }

        //第二次遍历,将于map中找到的key放入list中
        ArrayList<Integer> list = new ArrayList<>();
        for (int aNums2 : nums2) {
            //在map集合中有对应的键值对且次数不为空
            if (map.containsKey(aNums2) && map.get(aNums2) > 0) {
                //转移到list集合中
                list.add(aNums2);
                //转移完了，map集合对应的键值对次数-1
                map.put(aNums2, map.get(aNums2) - 1);
            }
        }

        //将list集合的值取出返回到数组
        int[] ints = list.stream().mapToInt(x -> x).toArray();
        return ints;
    }

     public static void main(String[] args) {
         Solution349_2 solution349 = new Solution349_2();
         int[] nums1 = {1, 2, 2, 1};
         int[] nums2 = {2,2};
         int[] ints = solution349.intersection(nums1, nums2);
         System.out.println(Arrays.toString(ints));
     }
}
