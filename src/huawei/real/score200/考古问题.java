package huawei.real.score200;

import java.util.*;

/**
 * 考古问题，假设以前的石碑被打碎成了很多块，每块上面都有一个或若干个字符，请你写个程序来把之前石碑上文字可能的组合全部写出来，排序按大小升序
 *
 * 输入
 * 3
 * a b c
 * 输出
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 *
 * 输入
 * 3
 * a b a
 * 输出
 * aab
 * aba
 * baa
 */
public class 考古问题 {
    /**
     * 把那些碎片当做一个字符串集合，每次取一块（排列组合），然后递归继续取，最后取完了就把最后的字符串丢到Set集合中去重。最后排个序输出。其中一定要注意List、StringBuilder这种对象进行递归调用传递参数的时候传递的是引用类型，所以每次操作完下去递归的时候都是需要复制一份的，不要直接传递会改的同一份的。
     * ————————————————
     * 版权声明：本文为CSDN博主「HumoChen99」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/HumorChen99/article/details/120329819
     * @param args
     */
     public static void main(String[] args) {
         //考古问题
         Scanner scanner = new Scanner(System.in);
         int n  = Integer.parseInt(scanner.nextLine());
         String str = scanner.nextLine();
         String[] strings = str.split(" ");
         ArrayList<String> items = new ArrayList<>();
         for (String s : strings){
             items.add(s);
         }
         HashSet<String> hashSet = new HashSet<>();
         dynamicCombine(items,new StringBuilder(),hashSet);
         //最后排序
         List<String> list = new ArrayList(strings.length);
         Iterator<String> iterator = hashSet.iterator();
         while (iterator.hasNext()){
             list.add(iterator.next()); }
         list.sort((Comparator.comparing(o -> ((String) o))));
         for (String s : list){
             System.out.println(s); } }
    private  static void dynamicCombine(ArrayList<String> items, StringBuilder builder, HashSet<String> ret){
        if (items.size() != 0){
            for (int i = 0,len = items.size(); i < len ;i++){
                StringBuilder newBuilder = new StringBuilder(builder);
                newBuilder.append(items.get(i));
                ArrayList<String> newItems = new ArrayList<>();
                for (int j = 0; j < len;j++){
                    newItems.add(j,items.get(j));
                }
                newItems.remove(i);
                dynamicCombine(newItems,newBuilder,ret);
            }
        }else {
            if (builder.length() > 0){
                ret.add(builder.toString()); }
            return; } }
}
