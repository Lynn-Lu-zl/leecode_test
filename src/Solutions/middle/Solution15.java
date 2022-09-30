package Solutions.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**三数之和
 *
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution15 {


    /**1、三数互不相等，[nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
     *--》 数组索引一定要不同，但是数组索引对应的值可以相同，意思是结果不能重复数组，但是可以重复元素
     *nums = [-1,0,1,2,-1,-4]--》nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 --》i=0，j=3，k=4,互不相同但是nums[i]=nums[k]=-1
     *
     *
     * 2、三数之和=0，同时还满足 nums[i] + nums[j] + nums[k] == 0
     *
     * 3、返回所有和为 0 且不重复的三元组--》结果不能重复，{-2,0,0,2,2};--》[[-2, 0, 2], [-2, 0, 2]]
     *
     * 排序+双指针
     * 双指针条件：左指针在最左边+1，右指针在最右边
     * 如果sum=num[i] + num[left] + num[right] < 0 --》说明需要更大的数才能靠近0--》已经排好序了从左到右的值越来越大，所以左指针往右移left++继续找三数之和=0的元素
     * 如果sum=num[i] + num[left] + num[right] > 0--》已经超过0了，需要找更小的数来中和超出来的值--》右指针往左移right--
     *
     * 如果sum=num[i] + num[left] + num[right] = 0--》添加到list集合，这样还没完，左右指针都往中间靠可能还有相加等于0的数，但是如果左右指针相邻值相同可能会出现有重复的结果集
     * 如：{-2,0,0,2,2};--》[[-2, 0, 2], [-2, 0, 2]]
     *      0  1 2 3 4
     * i=0,left=1,right=4-->num[0]+num[1]+num[4]=-2+0+2=0-->[-2, 0, 2]添加到list-->left right往中间靠
     * i=0,left=2,right=3-->num[0]+num[2]+num[3]=-2+0+2=0-->[-2, 0, 2]添加到list-->发现两个一模一样顺序的结果集，重复了
     * 虽然i、j、k不相同，但是组成结果元素的顺序相同，原因是left、right都往中间靠的时候，它们出现的值和上次的一模一样--》left、right相邻的两个值都是一样的--》
     * 避免这种重复结果的出现，一旦出现nums[left] == nums[left+1]/nums[right] == nums[right-1]左右指针相邻元素都相同的就不比较了，+1继续比较
     *
     * 相邻索引值重复导致重复结果集去重-》假如当前索引值和前一个索引值相同，而前一个索引i已经有加入list集合三数之和了，后一个和它相同的索引值肯定也跟它一样，这样会导致相同的结果集--》如果存在 num[i-1] == num[i] && i>0--》直接进入下一次循环不用浪费这次的循环流程，相当于相同类型的节目打分肯定相同，这样我们也没有必要再去看相同类型的节目了
     *如：{-4,-1,-1,0,1,2}--》[[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
     *     0  1  2  3 4 5
     * num[1]+num[2]+num[5]=-1-1+2=0->[-1,-1,2] -->添加到集合list
     * num[1]+num[3]+num[4]=-1+0+1=0->[-1,0,1] -->添加到集合list
     * num[2]+num[3]+num[4]=-1+0+1=0->[-1,0,1] 添加到list-->发现两个一模一样顺序的结果集，重复了
     * 原因是num[1]、num[2]都是一样的，num[2]的相加和过程 跟 前一个索引是一样--》避免这样的情况出现，如果当前索引即num[2]发现和前一个索引num[1]相同-》直接进入下一个循环
     *
     *
     * 利用好有序数组--》数组元素越往后值越大，num[i]>0 就可以结束循环，因为题目要求的是和等于0，后面值越来越大导致和只会大于0且越来越大，没必要继续
     * 相当于一个全部都大于0的有序数组，[2,5,6,7,10]，在i=0的时候就没有必要遍历了
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length <3){
            return list;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //数组元素越往后值越大，num[i]>0 就可以结束循环
            if (nums[i] > 0){
                return list;
            }
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
                if (sum < 0 ){
                    left ++;
                }else if (sum > 0){
                    right --;
                }else if (sum == 0){
                    //三数之和为0添加到集合list
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
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
        return list;
    }

     public static void main(String[] args) {
         Solution15 solution15 = new Solution15();
         //左右指针相邻去重{-2,0,0,2,2}

         int[] ints = {-1,0,1,2,-1,-4};
         // int[] ints = {0,0,0};
         System.out.println(solution15.threeSum(ints));
     }
}
