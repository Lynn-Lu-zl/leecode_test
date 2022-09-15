package huawei.real.score200;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *https://f.daixianiu.cn/csdn/06659718672286397.html
 * 警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如“HH:MM”表示的时刻。
 * 根据警察和线人的约定，为了隐蔽，该时间时修改过的，解密规则为：利用当前出现过的数字，构造下一个距离当前时间最近的时刻，则该时间为可能的犯罪时间。
 * 每个出现数字都可以被无限次使用
 * 示例
 *
 * 20:12得到20:20
 * 23:59得到22:22
 * 12:58得到15:11
 * 18:52得到18:55
 * 23:52得到23:53
 * 09:17得到09:19
 * 07:08得到08:00
 *
 *
 * 解题思路：
 *
 * 根据题意可以判断时间都是由四个数字组成，把时间各数取出按序放入数组中
 * 对四个数进行全遍历，获取所有可能的时间（必须符合时间格式要求），并跟错误时间进行比较。分别取出大于错误时间的最小值和小于错误时间的最小值。
 * 如果存在大于错误时间的最小值，则最小值为犯罪时间；若不存在，小于错误时间的最小值为犯罪时间
 */
public class 解密犯罪时间 {

    public static void main(String[] args) {
        //解密犯罪时间
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int errorTime = Integer.parseInt(s.substring(0,2)+s.substring(3));
        String[] num = new String[4];
        num[0] = String.valueOf(s.charAt(0));
        num[1] = String.valueOf(s.charAt(1));
        num[2] = String.valueOf(s.charAt(3));
        num[3] = String.valueOf(s.charAt(4));
        int time;
        int min = Integer.MAX_VALUE;    //小于错误时间的最小时间（第二天）
        int minThan = Integer.MAX_VALUE;    //大于错误时间的最小时间
        for(int i=0;i<4;i++){
            if(Integer.parseInt(num[i])>2){ //首位不能大于2
                continue;
            }
            for(int j=0;j<4;j++){
                if(Integer.parseInt(num[i])==2 && Integer.parseInt(num[j])>3){  //第一位为2时第二位则不能大于3
                    continue;
                }
                for(int k=0;k<4;k++){
                    if(Integer.parseInt(num[k])>=6){ //第三位不能大于6
                        continue;
                    }
                    for(int l=0;l<4;l++){
                        time = Integer.parseInt(num[i]+num[j]+num[k]+num[l]);   //重构的时间
                        if(time<errorTime){
                            min = Math.min(min,time);
                        }else if(time>errorTime){
                            minThan = Math.min(minThan,time); } } } } }
        String res;
        if(minThan == Integer.MAX_VALUE){ //若重构的时间都小于错误时间，则时间为第二天时间
            res = String.valueOf(min);
        }else {
            res = String.valueOf(minThan);
        }
        System.out.println(res.substring(0,2)+":"+res.substring(2));

    }



}
