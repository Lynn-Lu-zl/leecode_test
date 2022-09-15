package huawei.real.score100;

import java.util.*;

/**
 *   幼儿园两个班的小朋友排队时混在了一起
 *   每个小朋友都知道自己跟前面一个小朋友是不是同班
 *   请你帮忙把同班的小朋友找出来
 *   小朋友的编号为整数
 *   与前面一个小朋友同班用Y表示
 *   不同班用N表示
 *   输入描述：
 *   输入为空格分开的小朋友编号和是否同班标志
 *   比如 6/N 2/Y 3/N 4/Y
 *   表示一共有4位小朋友
 *   2和6是同班 3和2不同班 4和3同班
 *   小朋友总数不超过999
 *   0< 每个小朋友编号 <999
 *   不考虑输入格式错误
 *
 *   输出两行
 *   每一行记录一班小朋友的编号  编号用空格分开
 *   并且
 *   1. 编号需要按照大小升序排列，分班记录中第一个编号小的排在第一行
 *   2. 如果只有一个班的小朋友 第二行为空
 *   3. 如果输入不符合要求输出字符串ERROR
 *
 *   示例：
 *   输入
 *   1/N 2/Y 3/N 4/Y
 *   输出
 *   1 2
 *   3 4
 *   说明：2的同班标记为Y因此和1同班
 *   3的同班标记位N因此和1,2不同班
 *   4的同班标记位Y因此和3同班
 */

public class 小朋友分班 {


        // public static void main(String[] args) {
        //     Scanner sc = new Scanner(System.in);
        //     String line = sc.nextLine();
        //     String[] input = line.split(" ");
        //     List<Integer> list1 = new ArrayList<>();
        //     List<Integer> list2 = new ArrayList<>();
        //
        //     //0号是1班 剩下是2班
        //     int preCla = 1;
        //     for (int i = 0; i < input.length; i++) {
        //         String[] num = input[i].split("/");
        //         if (i == 0) {
        //             list1.add(Integer.parseInt(num[0]));
        //             preCla = 1;
        //             continue;
        //         }
        //         if (preCla == 1) {
        //             if (num[1].equals("Y")) {
        //                 list1.add(Integer.parseInt(num[0]));
        //             } else {
        //                 list2.add(Integer.parseInt(num[0]));
        //                 preCla = 2;
        //             }
        //         } else {//N
        //             if (num[1].equals("Y")) {
        //                 list2.add(Integer.parseInt(num[0]));
        //             } else {
        //                 list1.add(Integer.parseInt(num[0]));
        //                 preCla = 1;
        //             }
        //         }
        //     }
        //     Collections.sort(list1);
        //     Collections.sort(list2);
        //     for (int i = 0; i < list1.size(); i++) {
        //         System.out.print(list1.get(i) + " ");
        //     }
        //     System.out.println();
        //     for (int i = 0; i < list2.size(); i++) {
        //         System.out.print(list2.get(i) + " ");
        //     }
        // }

    /**
     * 法二、打印了ERROR
     * 既然他是两个班级，我就搞两个集合，定义为1班、2班，然后从第一个孩子开始，第一个孩子直接往1班送，然后后面那个孩子如果是同班就是在1班，否则就是2班，后面的学生就会像诺米勒骨牌效应一样，一个个都能算出来了，算完之后对1、2班集合里的学号排序，然后如果第二个集合的第一个学生学号比第一个集合的小就换个顺序，如果第一个空的第二个有，那也要换顺序，最后数据到位了，打印即可
     */
    public static final String ERROR = "ERROR";
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         String data = scanner.nextLine();
//         if (!data.equals("")){
//             String[] datas = data.split(" ");
//             if (datas.length > 0){
//                 List<Integer> cls1 = new ArrayList<>();
//                 List<Integer> cls2 = new ArrayList<>();
//                 Student[] students = new Student[datas.length];
//                 for (int i = 0;i < datas.length ;i++){
//                     try {
//                         if (!datas[i].equals("")){
//                             students[i] = new Student(datas[i]);
//                             if (students[i].num <= 0 || students[i].num >999){
//                                 throw new RuntimeException("num error");
//                             }
//                         }
//                     }catch (RuntimeException e){
//                         System.out.println(ERROR);
//                         return;
//                     }
//                 }
//                 //先假设第一个同学是第一个班的（最后再根据最小学号来定一二班）
//                 cls1.add(students[0].num);
//                 int lastCls = 1;
//                 if (students.length > 1){
//                     for (int i = 1, len = students.length; i < len;i++){
//                         Student student = students[i];
//                         if (student.same){
//                             //和上个人是同一个班
//                             if (lastCls == 1){
//                                 cls1.add(student.num);
//                             }else {
//                                 //不是同一个班的
//                                 cls2.add(student.num);
//                                 lastCls = 2;
//                             }
//                         }else {
//                             if (lastCls == 1){
//                                 cls2.add(student.num);
//                                 lastCls = 2;
//                             }else {
//                                 cls1.add(student.num);
//                                 lastCls = 1;
//                             }
//                         }
//                     }
//                 }
//                 //全部分班完成之后，排序
//                 if (cls1.size() > 0){
//                     cls1.sort((Comparator.comparingInt(o -> o)));
//                 }
//                 if (cls2.size() > 0){
//                     cls2.sort((Comparator.comparingInt(o -> o)));
//                 }
//                 //转换班级
//                 if (cls1.size() > 0 && cls2.size() > 0){
//                     //两个班都有学生
//                     if (cls1.get(0) > cls2.get(0)){
//                         //替换顺序(第一个编号小的放前面)
//                         List<Integer> tmp = cls1;
//                         cls1 = cls2;
//                         cls2 = tmp;
//                     }
//                 }else {
//                     //只有一个班有学生
//                     if (cls2.size() > 0){
//                         //替换顺序
//                         List<Integer> tmp = cls1;
//                         cls1 = cls2;
//                         cls2 = tmp;
//                     }
//                 }
//                 //打印输出
//                 printList(cls1);
//                 printList(cls2);
//             }else {
//                 System.out.println(ERROR);
//             }
//         }else {
//             System.out.println(ERROR);
//         }
//     }
//     public static void printList(List<Integer> list){
//         if (list.size() > 0){
//             for (int i = 0,len = list.size();i < len;i++){
//                 if (i != 0){
//                     System.out.print(" ");
//                 }
//                 System.out.print(list.get(i));
//             }
//             System.out.print("\n");
//         }else {
//             System.out.println();
//         }
//     }
// }
// class Student {
//     int num;
//     boolean same;
//     public Student(String s){
//         //转化
//         String[] datas = s.split("/");
//         if (datas.length == 2){
//             this.num = Integer.parseInt(datas[0]);
//             this.same = datas[1].equals("Y");
//         }else {
//             throw new RuntimeException("format illegal");
//         }
//     }
//
//     @Override
//     public String toString() {
//         return "Student{" +
//             "num=" + num +
//             ", same=" + same +
//             '}';
//     }


    /**
     * 法三
     * 不是100%，error有些不行
     */
    // public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);
    //     String teamStr = scanner.nextLine();
    //
    //     String[] childs = teamStr.split(" ");
    //
    //     if (childs.length > 999) {
    //         System.out.println("ERROR");
    //     }
    //
    //     // 分开两个班级
    //     ArrayList<String> classA = new ArrayList<>();
    //     ArrayList<String> classB = new ArrayList<>();
    //     String classNum = "";
    //     for (int i = 0; i < childs.length; i++) {
    //         if (i == 0) {
    //             String first = childs[0];
    //             classA.add(first.split("/")[0]);
    //             classNum = "A";
    //             continue;
    //         }
    //         String follow = childs[i];
    //         boolean isSameClass = follow.endsWith("Y");
    //
    //         String stu = follow.split("/")[0];
    //
    //         if ("A".equals(classNum)) {
    //             if (isSameClass) {
    //                 classA.add(stu);
    //             } else {
    //                 classB.add(stu);
    //             }
    //             classNum = isSameClass ? "A" : "B";
    //         } else {
    //             if (isSameClass) {
    //                 classB.add(stu);
    //             } else {
    //                 classA.add(stu);
    //             }
    //             classNum = isSameClass ? "B" : "A";
    //         }
    //     }
    //
    //     classA.sort(Comparator.comparingInt(Integer::parseInt));
    //     classB.sort(Comparator.comparingInt(Integer::parseInt));
    //
    //     System.out.println(classA.toString().replace("[", "").replace("]", "").replace(",", " "));
    //     System.out.println(classB.toString().replace("[", "").replace("]", "").replace(",", " "));
    // }
    
    
     public static void main(String[] args) {

         //小朋友分班,幼儿园两个班的小朋友排队时混在了一起
         Scanner in = new Scanner(System.in);
         String[] stus = in.nextLine().split(" ");
         try {
             TreeSet<Integer> c1 = new TreeSet<>();
             TreeSet<Integer> c2 = new TreeSet<>();
             boolean is1 = true;
             for (int i = 0; i < stus.length; i++) {
                 String[] split = stus[i].split("/");
                 String id = split[0];
                 String same = split[1];
                 if (i == 0) {
                     c1.add(Integer.parseInt(id));
                     continue; }
                 if ("N".equals(same)) is1 = !is1;
                 (is1 ? c1 : c2).add(Integer.parseInt(id)); }
             StringBuilder b1 = new StringBuilder();
             for (Integer id : c1) b1.append(id).append(" ");
             if (c2.size() > 0) {
                 StringBuilder b2 = new StringBuilder();
                 for (Integer id : c2) b2.append(id).append(" ");
                 if (c1.first() < c2.first()) {
                     System.out.println(b1.toString().trim());
                     System.out.println(b2.toString().trim());
                 } else {
                     System.out.println(b2.toString().trim());
                     System.out.println(b1.toString().trim()); }
             } else {
                 System.out.println(b1.toString().trim()); } }
                 catch (Exception e) {
             System.out.println("ERROR");}


     }



}
