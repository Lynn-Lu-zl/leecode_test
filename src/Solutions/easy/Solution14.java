package Solutions.easy;

/***
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Solution14 {
    // public String longestCommonPrefix(String[] strs) {
    //     if (strs.length == 0){
    //         return "";
    //     }
    //     //用于存储字符串遍历的最小长度
    //     int len=strs.length;
    //
    //     //外层for循环遍历每个字符索引，注意strs[0].length长度是不断变化的
    //     for (int i = 0; i < strs[0].length(); i++) {
    //         //取出单个字符，用于字符串之间的匹配
    //         char c = strs[0].charAt(i);
    //         /*当需要匹配的字符索引超过字符串的长度，
    //                 或者字符串某个位置的字符不匹配时，削减最长前缀
    //                 同时要刷新字符串遍历的最小长度len（因为超过len的部分肯定不匹配了）*/
    //         for (int j=0;j<len;j++)
    //             if (strs[j].charAt(i) != c || strs[j].length() == i) {
    //                 strs[0]=strs[0].substring(0, i);
    //                  len = j;
    //         }
    //     }
    //     //返回最长公共前缀
    //     return strs[0];
    // }

    /**
     * 函数`substring(int beginIndex, int endIndex)`：截取字符串的一部分，注意endIndex不取
     * 函数`startsWith(String str)`：判断某个字符串是否以str为开头
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
          return "";
        }
        //用于储存最长公共前缀，初始化为strs[0]，以flower为基准
        String res = strs[0];
        //用前缀flower，遍历字符串数组
        for (String str : strs) {
            while ( ! str.startsWith(res)){
                //循环，flow不以flower开始--》所以将res截取长度，每次截取最后的一个字符继续比较
                //flower ≠flow -->flowe≠flow-->flow =flow 这是和字符串数组的flow前缀一样了--》终止内存循环，继续遍历flight
                //  flight≠flow --> flight≠flo-->flight=fl开头
                res = res.substring(0,res.length()-1);
            }
        }
        return res;
    }


     public static void main(String[] args) {
         Solution14 solution14 = new Solution14();

         String[] strings = {"flower", "flow", "flight"};
         System.out.println(solution14.longestCommonPrefix(strings));
     }
}
