package DataStructure.集合.Collection.List;

import java.util.List;
import java.util.Vector;

/**
 * 底层是数组，和ArrayList一样
 * 线程安全，加了锁
 * 方法由于加了 synchronized 修饰，因此 Vector 是线程安全容器，但效率上较ArrayList差
 *
 */
public class VectorTest {
     public static void main(String[] args) {
         List<Character> vector = new Vector<>();
         //vector.remove();
     }
}
