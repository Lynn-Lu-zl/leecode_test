package Method.字符串;

/**
 * 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 *
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 *
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 包含英文大小写字母、数字和空格 ' '
 * s 中 至少存在一个 单词
 */
public class Solution151 {
    /**
     * 双指针
     * 左右指针倒序，左指针做探路
     * 时间On，空间On
     * @param s
     * @return
     */
    public String reverseWords(String s) {



        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;
        int left = s.length()-1;

        while (left >= 0){
            //左指针倒序遍历探路，走到第一个单词结束的地方即遇到空格暂停
            while (left >= 0 && s.charAt(left) != ' '){
                left--;
            }
            //截取倒数第一组单词追加到字符串，别忘了加个单词分隔符
            sb.append(s.substring(left+ 1,right+ 1 ) + " ");

            //left左指针探路，跳过空格后右指针跟上
            while (left >= 0 && s.charAt(left) == ' '){
                left--;
                //指向下个单词的尾字符
                right = left;
            }
        }
        return sb.toString().trim();
    }
     public static void main(String[] args) {
         Solution151 solution151 = new Solution151();
         System.out.println(solution151.reverseWords("the sky is blue"));
     }
}
