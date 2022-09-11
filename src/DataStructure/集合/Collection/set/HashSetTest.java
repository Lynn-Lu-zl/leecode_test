package DataStructure.集合.Collection.set;

import java.util.HashSet;

/**
 *collection框架有自己的接口和实现，主要分为Set接口，List接口和Queue接口
 *
 * HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
 *
 * HashSet 允许有 null 值。
 *
 * HashSet 是无序的，即不会记录插入的顺序。
 *
 * boolean add(E e)  //添加元素，如果元素添加不成功    返回值代表是否添加成功，
 * boolean remove(Object o)  //删除元素 ，返回值代表删除元素是否成功
 * boolean contains(Object o)  //判断元素是否存在
 * int size()  //获取集合的大小
 */
public class HashSetTest {
     public static void main(String[] args) {

         // add(); //添加元素，同一个元素被添加了两次，它在集合中也只会出现一次，因为集合中的每个元素都必须是唯一的。
         // contains(); // 判断元素是否存在于集合当中
         // remove(); // 删除集合中的元素,删除成功返回 true，否则为 false
         // clear(); //删除集合中所有元素
         // size(); //计算 HashSet 中的元素数量
         // for (String i : sites) //可以使用 for-each 来迭代 HashSet 中的元素。
         //     isEmpty(); // 判断集合是否为空
         // toArray(); //将内容转到数组中


         HashSet<Integer> hashSet = new HashSet<>();
         //hashSet.add()

     }
}
