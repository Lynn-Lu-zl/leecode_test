package DataStructure.String;

import java.util.Arrays;

/**
 * char charAt(int index)  //返回指定索引处的 char 值。
 * String concat(String str) //将指定字符串连接到此字符串的结尾。
 * boolean contentEquals(StringBuffer sb) //当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真。
 * int indexOf(int ch) //返回指定字符在此字符串中第一次出现处的索引。
 * int indexOf(String str) //返回指定子字符串在此字符串中第一次出现处的索引。
 * int lastIndexOf(int ch) //返回指定字符在此字符串中最后一次出现处的索引。
 * int lastIndexOf(String str) //返回指定子字符串在此字符串中最右边出现处的索引。
 * int length() //返回此字符串的长度。
 * String replace(char oldChar, char newChar) //返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 * String substring(int beginIndex) //返回一个新的字符串，它是此字符串的一个子字符串。
 * char[] toCharArray() //将此字符串转换为一个新的字符数组。
 * String toLowerCase() //使用默认语言环境的规则将此 String 中的所有字符都转换为小写。
 * String toUpperCase() //使用默认语言环境的规则将此 String 中的所有字符都转换为大写。
 * String toString() //返回此对象本身（它已经是一个字符串！）。
 * String trim() //返回字符串的副本，忽略前导空白和尾部空白。
 * contains(CharSequence chars) //判断是否包含指定的字符系列。
 * isEmpty() //判断字符串是否为空。
 * String[] split(String regex) //根据给定正则表达式的匹配拆分此字符串。
 */
public class StringTest {
     public static void main(String[] args) {

         /**
          * 字符串的大小  len=str.length();
          * 提取字符串中的某一个下标 str.charAt(6)
          * 查找字符出现的位置str.indexOf('o')
          * 找子串 str.substring(4,5)
          * 反转 String string="runoob"; String reverse = new StringBuffer(string).reverse().toString();
          * 字符串判单是否相等 str.equals("+"); 为什么不能用==来判断？
          * 替换字符 public String replace(char searchChar, char newChar)
          * split函数的目的是分割字符串，然后保存到一个String数组中
          */
         //强转类型，String.valueOf(5)，将int类型转成字符串类型
         //String value = String.valueOf(5);
         //System.out.println(value);

         //String string = new String();
         //字符串常量池创建字符串对象
         String string = "abc";
         // string.isEmpty();
         // string.length();
         // string.equals();
         // string.replaceAll(, );
         // string.contains();
         // string.matches();


         //截取某个位置的
         // string.substring();
         //分割字符串，然后保存到一个String数组中
         // string.split();
         String str="My name is Benjamin.";
         str=str.toLowerCase();
         String [] words=str.split("\\W+");//正则表达式 按照空格进行分割
         String ar1=Arrays.toString(words);
         System.out.println(ar1);
//[my, name, is, benjamin]


         //将索引值从字符串转换成字符类型返回，如字符串为“abc”，索引为0的元素返回为'a'，索引为1返回'b'
         char c = string.charAt(0);
         System.out.println(c);

         /**
          * 字符串转数字 Integer.parseInt(Str);
          * 数字转字符串 String s = inta+""; 或者 String s1=x.toString();
          * 字符串转数组 char[] c=s.toCharArray();
          * 数组转字符串 String res=new String(c);
          */
         //转换成字符型数组
         char[] charArray = string.toCharArray();
         System.out.println(charArray);

         //字符串转数字int 数字转字符串
         String Str = new String("123");
         Integer a=Integer.parseInt(Str);
         int a2 = Integer.parseInt(Str);
         double b=Double.parseDouble(Str);
         int inta=234;
         String s = inta+"";
         //char c='1';
         Integer x = 5;
         //将int转成字符串类型
         String s1=x.toString();
         System.out.println(s1);

         // string.lastIndexOf();
         // string.indexOf();


         // string.startsWith();
         // string.endsWith();

         // string.compareTo();
         // string.compareToIgnoreCase();

         // string.toLowerCase();
         // string.intern();
         // string.getBytes();

         //返回一个字符串，其值为该字符串，删除了任何前导和尾随的空格
         String trim = string.trim();
         System.out.println(trim);



     }

}
