package Method.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution03 {

    /**
     * 双指针+滑动窗口
     * <p>
     * "dvdf"-->左右指针一开始都在最左边，然后遍历字符串，
     * 如果set集合没有该元素--》添加到set中--》右指针继续移动+1--》记录长度--》比较set集合的长度和当前最大长度哪个大
     * 如果set有该元素--》重复子串--》将重复的该元素从set集合移除--》左指针向右移动+1--》因为移除了之前重复元素，所以回到循环时又要把之前移除的元素又重新添加
     * <p>
     * dvdf
     * 0123
     * -->right指针移到索引为0时没有重复，set=d-->right+1，长度1
     * -->right指针移到索引为1时没有重复，set=dv-->right+1，长度2
     * -->right指针移到索引为2时发现第二个d是重复,
     * -->set集合移除第一个出现的d即当前left指针的索引-->left+1，最大长度2
     * -->因为上一次right没有+1-->right指针继续判断索引为2,此时索引为0的d已经移除了，索引为2的d可以保留添加到set集合
     * -->set=vd-->right+1,最大长度2
     * -->right指针移到索引为3时没有重复，set=vdf-->right+1，最大长度3
     * 此时right=4>字符串长度--》返回最大长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        if (s.length() == 0)return 0;

            while (right < s.length()){
                if ( ! set.contains(s.charAt(right))){
                    set.add(s.charAt(right));
                    right++;
                }else {
                    set.remove(s.charAt(left));
                    left++;
                }
                maxLength = Math.max(maxLength,set.size());
            }

        return maxLength;
    }


    public static void main(String[] args) {
        Solution03 solution03 = new Solution03();
        String s = "abcabcbb";
        System.out.println(solution03.lengthOfLongestSubstring(s));
    }
}