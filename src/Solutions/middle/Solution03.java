package Solutions.middle;

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
     *
     * "dvdf"-->左右指针一开始都在最左边，然后遍历字符串，
     * 如果set集合没有该元素--》添加到set中--》右指针继续移动+1--》记录长度--》比较set集合的长度和当前最大长度哪个大
     * 如果set有该元素--》重复子串--》将重复的该元素从set集合移除--》左指针向右移动+1--》因为移除了之前重复元素，所以回到循环时又要把之前移除的元素又重新添加
     *
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
        int maxLength=1;
        int left=0;
        int right=0;
        Set<Character> set = new HashSet<>();
        if (s.length() <= 1){
            return s.length();
        }
        while (right < s.length()){
            if ( ! set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else {
                set.remove(s.charAt(left));
                left++;
                // set.clear();
                // left = right-1;
            }
            maxLength = Math.max(maxLength,set.size());
        }
        return maxLength;
    }


//     public int lengthOfLongestSubstring(String s) {
// /**
//  1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
//  此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
//
//  2、如果当前字符 ch 包含在 map中，此时有2类情况：
//  1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
//  那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
//  2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
//  而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
//  随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
//  应该不变，left始终为2，子段变成 ba才对。
//
//  为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
//  另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
//  因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
//  */
//         HashMap<Character, Integer> map = new HashMap<>();
//         int maxLen = 0;//用于记录最大不重复子串的长度
//         int left = 0;//滑动窗口左指针
//         for (int i = 0; i < s.length() ; i++)
//         {
//             if(map.containsKey(s.charAt(i))) {
//                 left = Math.max(left , map.get(s.charAt(i))+1);
//             }
//             //不管是否更新left，都要更新 s.charAt(i) 的位置！
//             map.put(s.charAt(i) , i);
//             maxLen = Math.max(maxLen , i-left+1);
//         }
//         return maxLen;
//     }


    /**
     * 滑动窗口
     * 时间复杂度On
     * @param s
     * @return
     */
    // public int lengthOfLongestSubstring(String s) {
    //
    //     int left=0;
    //     int right=0;
    //     int length=0;
    //     int maxLen = 0;//用于记录最大不重复子串的长度
    //     HashSet<Character> set = new HashSet<>();
    //     while (right < s.length()){
    //         if ( ! set.contains(s.charAt(right))){
    //            set.add(s.charAt(right));
    //            length++;
    //            if (length > maxLen){
    //                maxLen = length;
    //            }
    //             right++;
    //         }
    //
    //         else {
    //             while (set.contains(s.charAt(right))){
    //                 set.remove(s.charAt(left));
    //                 left++;
    //                 length--;
    //             }
    //             set.add(s.charAt(right));
    //             length++;
    //             right++;
    //         }
    //
    //     }
    //     return maxLen;
    // }

     public static void main(String[] args) {
         Solution03 solution03 = new Solution03();
         String s ="dvdf";
         System.out.println(solution03.lengthOfLongestSubstring(s));
     }
}
