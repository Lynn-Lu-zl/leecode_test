package Solutions.剑指offer.easy.最长不含重复字符的子字符串48;//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-rep
//eating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 497 👎 0


import Solutions.middle.Solution48;

import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 滑动窗口，用set维护一个不重复的窗口
     * 使用集合set来代替队列，
     * 用两个指针，
     * 一个left一个right，
     * 如果有重复的就把left指向的给移除（left相当于队首，right相当于队尾）
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int max=0;
        //左指针
        int left=0;
        //右指针
        int right=0;
        while (right < s.length()){
            if (set.contains(s.charAt(right))){
                //
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                //更新最长字符串
                max = Math.max(max, set.size());
                // max = Math.max(max,right-left);
            }
        }
        return max;
    }


     public static void main(String[] args) {

         Solution solution = new Solution();
         System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
     }
}
//leetcode submit region end(Prohibit modification and deletion)
