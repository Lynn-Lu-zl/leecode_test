package huawei.real.score200;

import java.util.Scanner;

/**
 * https://f.daixianiu.cn/csdn/41498922708949604.html
 * 九宫格按键输入，有英文和数字两个模式，默认是数字模式，数字模式直接输出数字，英文模式连续按同一个按键会依次出现这个按键上的字母，如果输入“/”或者其他字符，则循环中断，输出此时停留的字母。
 *
 * 数字和字母的对应关系如下，注意0只对应空格：
 *
 * 1（,.）2（abc）3（def）
 * 4（ghi）5（jkl）6（mno）
 * 7（pqrs）8（tuv）9（wxyz）
 * # 0（空格）/
 *
 * 输入一串按键，要求输出屏幕显示
 *
 * 1、#用于切换模式，默认是数字模式，执行#后切换为英文模式；
 * 2、/表示延迟，例如在英文模式下，输入22/222，显示为bc，数字模式下/没有效果；
 * 3、英文模式下，多次按同一键，例如输入22222，显示为b；
 *
 * 输入描述:
 * 输入范围为数字0~9和字符 ‘#’、‘/’，输出屏幕显示，例如，
 * 在数字模式下，输入1234，显示 1234
 *
 * 在英文模式下，输入1234，显示 ,adg
 *
 * 输出描述:
 * 输出屏幕显示的字符
 *
 * 示例1
 * 输入
 *
 * 2222/22
 *
 * 输出
 *
 * 222222
 *
 * 说明
 *
 * 默认数字模式，字符直接显示，数字模式下/无效
 *
 * 示例2
 * 输入
 *
 * #2222/22
 *
 * 输出
 *
 * ab
 *
 * 说明
 *
 * #进入英文模式，连续的数字输入会循环选择字母，直至输入/，故第一段2222输入显示a，第二段22输入显示b
 *
 * 示例3
 * 输入
 *
 * #222233
 *
 * 输出
 *
 * ae
 *
 * 说明
 *
 * #进入英文模式，连续的数字输入会循环选择字母，直至输入其他数字，故第一段2222输入显示a，第二段33输入显示e
 */
public class 九宫格按键输入 {
    /**
     * 1、将按键上的字符放入集合中，且索引为按键数字
     *
     * 2、新建isEn（是否英文输入）为false，如果遇到#将isEn置反
     *
     *       temp=“”为上次输入数字（只有英文输入状态有值）
     *
     *       count=0为同一数字按键次数
     *
     * 3、当isEn为false时，输入若为“/”，直接跳过；若为数字，直接输出
     *
     * 4、当isEn为true时
     *
     *      1、输入为“/”，若temp为空，直接跳过；若不为空，则通过count求得temp数字上的字符输出，并将temp和count初始化
     *      2、输入为数字，如数字等于temp，count+1，如此刻为最后一个字符，通过count求得temp数字上的字符输出；如数字不等于temp，则通过count求得temp数字上的字符输出，并将temp=此次输入数字，count=1，如此次为最后一个字符，则也需要通过count求得temp数字上的字符输出
     *      3、输入为#，isEn置为false，若temp不为空，则通过count求得temp数字上的字符输出，并将temp和count初始化
     */
    public static String temp = "";   //上一次的数字按键
    public static StringBuffer sb = new StringBuffer();   //输出字符串
    public static int count = 0;  //按键次数
    public static String[] strings = {" ",",.","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        //九宫格按键输入
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean isEn = false;   //英文输入
        int len = s.length();
        for(int i=0;i<len;i++){
            String c = String.valueOf(s.charAt(i)); //本次的按键
            if(c.equals("#")){  //中英文切换
                isEn = !isEn;
                if (temp!=""){  //temp有值，说明有字符需要输出
                    uotput(temp);
                    count = 0;  //输出完，count和temp初始化
                    temp = "";
                }
                continue;
            }
            if(isEn){
                /**
                 * 英文输入
                 */
                if(temp.equals("")){
                    if(c.equals("/")){
                        continue;
                    }
                    temp = c;
                    count = 1;
                    if(i==len-1){   //最后一个
                        uotput(c);
                        break;
                    }
                }else if(!temp.equals(c)){   //按键数字发生变化，需要输出字符
                    uotput(temp);
                    if(c.equals("/")){
                        count = 0;
                        temp = "";
                    }else {
                        count = 1;
                        temp = c;
                        if(i==len-1){   //最后一个
                            uotput(c);
                            break;
                        }
                    }
                }else {
                    count++;
                    if(i==len-1){   //最后一个
                        uotput(c);
                    }
                }
            }else {
                /**
                 * 数字输入
                 */
                if(c.equals("/")){  //数字中的/没有意义
                    continue;
                }
                sb.append(c);   //数字直接输出
            }
        }
        System.out.println(sb);
    }
    public static void uotput(String str){  //输出文字
        int strIndex = Integer.valueOf(str);   //上一次的按键（数字）
        if(strIndex==0){
            sb.append(" "); //0只有空格
        }else {
            int strLen = strings[strIndex].length();    //数字上的字符长度
            int index = count%strLen == 0 ? strLen-1 : count%strLen-1; //找到数字按钮上的对应字母位置
            sb.append(strings[strIndex].charAt(index));
        }
    }
}
