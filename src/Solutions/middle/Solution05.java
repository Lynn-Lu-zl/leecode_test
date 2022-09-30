package Solutions.middle;

/**5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *回文串：正着读，反着读得到的字符串都是一样的
 * 如：aba bbb ababa abba
 * abb ×
 * baba ×
 *
 * 规律：
 * 从中间分隔开左右对称的：判断中间的数是不是回文子串+最两边的数是否相等
 * 如果是奇数：aba--》最左边和最右边相等都是a，中间只有一个b肯定是回文子串--》最长3
 * 如果是偶数：abba-》最左边和最右边相等都是a，中间bb也相等，肯定是回文子串--》最长
 *  
 *中心扩散法
 * 1、首先先判断是否为回文子串--》
 * 定义左右指针，往外扩散判断一左一右是否相等
 *
 * 是，继续遍历直到两端尽头，截取索引长度
 * 否，break退出循环，直接返回0
 * 2、判断最大长度
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution05 {

    /**
     * 中心扩散法
     * 时间复杂度O(N的平方,N是字符串的长度),空间O(1)
     *枚举「中心位置」时间复杂度为 O(N)，从「中心位置」扩散得到「回文子串」的时间复杂度为 O(N)，因此时间复杂度可以降到 O(N^2)
     * 空间复杂度:O(1)，只使用到常数个临时变量，与字符串长度无关。
     * 遍历每一个下标，以这个下标为中心，利用「回文串」中心对称的特点，往两边扩散，看最多能扩散多远。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        //最长回文子串
        String maxStr ="";
        if (s.length() < 2){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            // 以单个字母为中心的情况
            String jiStr = getStr(s,i,i);
            // 以两个字母为中心的情况
            String ouStr = getStr(s,i ,i+1);
            //其实有3个变量比较，两两分开
            maxStr = maxStr.length() > jiStr.length() ? maxStr:jiStr;
            maxStr = maxStr.length() > ouStr.length() ? maxStr:ouStr;
        }
        return maxStr;

    }

    private String getStr(String s, int left, int right) {
        while (left >= 0 && right < s.length() ){
            if (s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else{
                break;
            }
        }
        //babad，substring左边取闭区间，右边开区间，substring[left,right)  左指针索引从0开始，因为先left减了再判断while条件再break，相当于多减了一次，补回来
        return s.substring(left + 1,right);
    }

    public static void main(String[] args) {
         Solution05 solution05 = new Solution05();
         String s="babad";
         System.out.println(solution05.longestPalindrome(s));
     }
}
