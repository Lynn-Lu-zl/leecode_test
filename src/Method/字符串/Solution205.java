package Method.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution205 {

    /**
     * 哈希映射
     *
     * 只需要在调用一次之后，判断哈希表的值里有没有相同元素，
     * 也就是看有没有s里的两个字母映射到了t里的同一个字母，有的话就False，没有就True
     *
     * 先建立映射关系--》put
     * 遍历
     * 如果发现有重复的key--》检查它的映射关系是不是一开始建立的
     * 如果不是--》非同构返回false
     * 如果是--》继续遍历直到字符串最后都没有重复的映射--》true
     * @param s
     * @param t
     * @return
     */

    public boolean isIsomorphic(String s, String t) {
        //s字符串到t的映射
        Map<Character, Character> sTot = new HashMap<>();
        //t字符串到s的映射
        Map<Character, Character> tTos = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            //s.charAt(i)：将索引值从字符串转换成字符类型返回，如字符串为“abc”，索引为0的元素返回为'a'，索引为1返回'b'
            if (sTot.containsKey(s.charAt(i))){
                if (sTot.get(s.charAt(i)) != t.charAt(i)){
                    return false;
                }
            }else {
                sTot.put(s.charAt(i),t.charAt(i));
            }
            if (tTos.containsKey(t.charAt(i))){
                if (tTos.get(t.charAt(i)) != s.charAt(i)){
                    return false;
                }
            }else {
                tTos.put(t.charAt(i),s.charAt(i));
            }

        }
        return true;
    }

    // public boolean isIsomorphic(String s, String t) {
    //     //s字符串到t的映射
    //     Map<Character, Character> sTot = new HashMap<>();
    //     //t字符串到s的映射
    //     Map<Character, Character> tTos = new HashMap<>();
    //
    //     for (int i = 0; i < s.length(); i++) {
    //
    //         //s.charAt(i)：将索引值从字符串转换成字符类型返回，如字符串为“abc”，索引为0的元素返回为'a'，索引为1返回'b'
    //         if (sTot.containsKey(s.charAt(i)) && sTot.get(s.charAt(i)) != t.charAt(i) ||
    //             tTos.containsKey(t.charAt(i)) && tTos.get(t.charAt(i)) != s.charAt(i)){
    //             return false;
    //         }
    //         sTot.put(s.charAt(i), t.charAt(i));
    //         tTos.put(t.charAt(i),s.charAt(i));
    //     }
    //     return true;
    // }


    // public boolean isIsomorphic(String s, String t) {
    //     for (int i = 0; i < s.length(); i++) {
    //         if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
     public static void main(String[] args) {
         Solution205 solution205 = new Solution205();

         String s = "egg";
         String t ="add";
         for (int i = 0; i < s.length(); i++) {

             //System.out.println(s.charAt(i));
             //System.out.println(s.indexOf(i));
             //System.out.println(s.indexOf(s.charAt(i)));
         }
         System.out.println(solution205.isIsomorphic("foo", "bar"));
     }
}
