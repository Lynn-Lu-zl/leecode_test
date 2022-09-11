package DataStructure.String;

/**
 * StringBuilder
 */
public class StringBuilderTest {
     public static void main(String[] args) {
         /**
          * charAt() 方法用于返回指定索引处的字符。索引范围为从 0 到 length() - 1。
          * 增加 sb.append 最后一位追加
          * 插入  sb.insert(8, "Java"); 指定位置增加
          * 删除  sb.delete(5,8);
          * 删除指定元素 sb.deleteCharAt(top);
          * 提取字串 sb.substring(0,3);  截取
          * 删除最后的元素 sb.delete(len-1,len);
          * 反转 sb.reverse();
          * 返回长度（字符数）sb.length()
          * 返回字符串 toString()
          */
         //StringBuilder stringBuilder = new StringBuilder();
         // stringBuilder.append();
         // stringBuilder.reverse();
         // stringBuilder.appendCodePoint();
         // stringBuilder.capacity();
         // stringBuilder.delete(, );
         // stringBuilder.replace(, , );

         String s="www.runoob.com";
         StringBuilder sb = new StringBuilder(s);

         sb.append("Runoob..");
         System.out.println(sb);
         sb.append("!");
         System.out.println(sb);
         //插入
         sb.insert(8, "Java");
         System.out.println(sb);
         //删除
         sb.delete(5,8);
         System.out.println(sb);
         //提取字串
         String substring=sb.substring(0,3);
         System.out.print("提取字串");
         System.out.println(substring);
         //删除最后的元素
         int len=sb.length();
         sb.delete(len-1,len);
         System.out.print("删除最后的元素");
         System.out.println(sb);

     }
}
