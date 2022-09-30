package Method.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class Soulution242 {
    /**
     * 找出哈希函数，就是把每一个 key 对应到 0 ~ N-1 的范围内，并且放在合适的位置。
     * 哈希函数 f(key) = key - ‘a’。这里其实是对字符 ASCII 的操作，字母 a ~ z 的 ASCII 是连续的 26 个数值。
     * 比如 f(a) = 'a' - 'a' = 0，f(b) = 'b' - 'a' = 1，即字母 a 对应的是哈希表下标为 0 的位置，字母 b 对应的是哈希表下标为 1 的位置，剩下的依此类推。
     *
     * 哈希函数找好，下面的就很简单：
     *
     * 遍历字符串 s，哈希表对应的字符值+1。
     * 遍历字符串 t，哈希表对应的字符值-1。
     * 如果两个字符串的每个字符数量都相同--》一加一减之后肯定为0
     * 如果哈希表中的值都为 0，则 s 和 t 互为字母异位词。
     *
     * 时间复杂度为 O(n)，n 为 s 和 t 中较长的那个字符串的长度
     * 额外开了一个长为 26 的数组，所以空间复杂度为 O(m)，m = 26
     *
     * 作者：rocky0429-2
     * 链接：https://leetcode.cn/problems/valid-anagram/solution/acm-xuan-shou-tu-jie-leetcode-you-xiao-d-npjv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {

        // f(key) = key - ‘a’-》f(key) = 字符串.charAt(i) - 'a'-->计算的结果就是哈希表下标的位置，26个字母，26个位置

        //初始化哈希表
        int[] ints = new int[26];

        //遍历字符串 s，碰到相应的字符，对应下标的哈希值 + 1
        //对于 s = “anagram”，第 1 个字符为 a，a 对应哈希表下标为 0，则下标 0 对应值 +1
        for (char c : s.toCharArray()) {
            ints[c - 'a'] += 1 ;
        }

        //第二步，遍历字符串 t，碰到对应的字符，相应下标的哈希值 -1。
        //
        // 对于 t = "nagaram"，第 1 个字符为 n，n 对应的下标为 13，则下标 13 对应的哈希值 -1：
        for (char c : t.toCharArray()) {
            ints[c - 'a'] -= 1;
        }

        //加加减减之后，如果哈希数组中的元素都为0说明是字符异位词
        for (int i : ints) {
            if ( i != 0 ){
                return false;
            }
        }

        return true;
    }
     public static void main(String[] args) {

         Soulution242 soulution242 = new Soulution242();
         System.out.println(soulution242.isAnagram("rat", "car"));
     }
}
