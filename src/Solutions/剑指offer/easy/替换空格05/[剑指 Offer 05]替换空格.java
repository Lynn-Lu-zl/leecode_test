package Solutions.剑指offer.easy.替换空格05;//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                stringBuilder.append("%20");
            }else{
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }


     public static void main(String[] args) {
         Solution solution = new Solution();
         String s = "We are happy.";
         String s1 = solution.replaceSpace(s);
         System.out.println(s1);
     }
}
//leetcode submit region end(Prohibit modification and deletion)
