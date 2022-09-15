package huawei.real.score100;

import java.util.*;

/**
 * 【英文输入法】
 *
 * 主管期望你来实现英文输入法单词联想功能。
 *
 * 需求如下：
 *
 * 依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，
 * 如果联想不到，请输出用户输入的单词前缀。
 * 注意：
 *
 * 英文单词联想时，区分大小写
 * 缩略形式如”don’t”，判定为两个单词，”don”和”t”
 * 输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * 输入描述
 *
 * 输入为两行。
 * 首行输入一段由英文单词word和标点符号组成的语句str；
 * 接下来一行为一个英文单词前缀pre。
 * 0 < word.length() <= 20
 *
 * 0 < str.length <= 10000
 *
 * 0 < pre <= 20
 *
 * 输出描述
 *
 * 输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例
 *
 * 输入
 *
 * I love you
 *
 * He
 *
 * 输出
 *
 * He
 *
 * 说明
 *
 * 从用户已输入英文语句”I love you”中提炼出“I”、“love”、“you”三个单词，接下来用户输入“He”，
 * 从已输入信息中无法联想到任何符合要求的单词，因此输出用户输入的单词前缀。
 */
public class 英文输入法 {

      public static void main(String[] args) {

          //英文输入法单词联想功能，I love you
          Scanner in = new Scanner(System.in);
          String[] str = in.nextLine().split("\\W+");
          String pre = in.nextLine();
          TreeSet<String> words = new TreeSet<>(Arrays.asList(str));
          StringBuilder buffer = new StringBuilder();
          for (String word : words) {
              if (word.startsWith(pre)) {
                  buffer.append(word).append(" "); } }
          if (buffer.length() == 0) buffer.append(pre);
          System.out.println(buffer.toString().trim());


      }

}
