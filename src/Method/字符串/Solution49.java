package Method.字符串;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 *
 */
public class Solution49 {

    /**
     * 1.对每个字符串排序--》自定义排序，因为"eat", "tea"无论字母的顺序怎么样，我都将它统一变成按字符顺序排序“aet”，
     * --》将这个统一的aet作为map的key，只要进来的单词字符排序后就是aet我就把它放进value即list集合中--》保证无论是eat、tea它都属于字母异位词
     * 2.跟map中对比，一样就把原字符串加入到value中，不一样就建一个新的
     * 3.把map中的value都加入结果。
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0){
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //转成字符数组
            char[] sChar = str.toCharArray();
            //对字符数组元素排序，
            Arrays.sort(sChar);
            //排序完又变成string字符串
            String find = new String(sChar);
            //跟map中对比，一样就把原字符串加入到value中，不一样就建一个新的
            if (map.containsKey(find)){
                List<String> stringList = map.get(find);
                stringList.add(str);
                map.put(find,stringList );
            }else {
                //不一样就建一个新的
                ArrayList<String> stringArrayList = new ArrayList<>();
                stringArrayList.add(str);
                map.put(find,stringArrayList);
            }
        }
        //将hashmap的值全部放在集合中，类型为List<String>
        ArrayList<List<String>> list = new ArrayList<>(map.values());
        return list;
    }

     public static void main(String[] args) {

         Solution49 solution49 = new Solution49();
         String[] strings = {
             "eat", "tea", "tan", "ate", "nat", "bat"
         };

         System.out.println(solution49.groupAnagrams(strings));
     }
}
