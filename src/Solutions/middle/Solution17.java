package Solutions.middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Solution17 {
    //存放最终结果
    ArrayList<String> list = new ArrayList<>();
    //存放临时结果
    StringBuilder temp = new StringBuilder();
    //使用HashMap存放字符与字符串对应关系
    Map phoneMap = new HashMap<Character,String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return list;
        }
        //回溯
        backtraking(digits,0);
        return list;
    }

    /**
     * 回溯模板
     * @param digits
     * @param index  “23”中的索引
     */
    private void backtraking(String digits, int index) {
        //终止条件，
        // 如果当前是最后一个数字，就把字符串添加进来
        if (index == digits.length()) {
            list.add(temp.toString());
            return;
        }

        //获得index对应的数字,获取当前的数字
        char charAt = digits.charAt(index);

        //获得数字对应的字符串
        String letter = (String) phoneMap.get(charAt);

        // 要把当前数字对应字母全部用一遍所以需要遍历
        for (int i = 0; i < letter.length(); i++) {
            //把当前字母加入排列
            temp.append(letter.charAt(i));

            //递归,去下一个数字中搜索字母
            backtraking(digits,index+1);

            //回溯,回溯到当前数字的位置把目前的字母删掉(然后下一轮循环添加下一个字母)
            temp.deleteCharAt(index);
        }

    }

    public static void main(String[] args) {
         Solution17 solution17 = new Solution17();
         String s="23";
         System.out.println(solution17.letterCombinations(s));
     }
}
