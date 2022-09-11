package DataStructure.集合.Collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * collection框架有自己的接口和实现，主要分为Set接口，List接口和Queue接口
 *Set 的集合里不允许对象有重复的值
 * Set接口
 * 中间实现类：AbstractSet--》实现类：hashset、treeset
 *
 */
public class SetTest {
     public static void main(String[] args) {
         //接口不能创建对象，只能创建它对应的实现类
         //Set<> set = new Set<Integer>();

       Set<Integer> hashSet = new HashSet<>();
     }
}
