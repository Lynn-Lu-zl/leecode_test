package huawei.real.score200;

import java.util.*;

/**
 * https://f.daixianiu.cn/csdn/48811850466749385.html
 * 企业路由器的统计页面，有一个功能需要动态统计公司访问最多的网页URL top N。请设计一个算法，可以高效动态统计Top N的页面。
 *
 * 输入描述:
 *
 * 每一行都是一个URL或一个数字，如果是URL，代表一段时间内的网页访问；如果是一个数字N，代表本次需要输出的Top N个URL。
 *
 * 输入约束：1、总访问网页数量小于5000个，单网页访问次数小于65535次；2、网页URL仅由字母，数字和点分隔符组成，且长度小于等于127字节；3、数字是正整数，小于等于10且小于当前总访问网页数；
 *
 * 输出描述:
 *
 * 每行输入要对应一行输出，输出按访问次数排序的前N个URL，用逗号分隔。
 *
 * 输出要求：1、每次输出要统计之前所有输入，不仅是本次输入；2、如果有访问次数相等的URL，按URL的字符串字典序升序排列，输出排序靠前的URL；
 *
 * 示例1
 * 输入
 *
 * news.qq.com
 *
 * news.sina.com.cn
 *
 * news.qq.com
 *
 * news.qq.com
 *
 * game.163.com
 *
 * game.163.com
 *
 * www.huawei.com
 *
 * www.cctv.com
 *
 * 3
 *
 * www.huawei.com
 *
 * www.cctv.com
 *
 * www.huawei.com
 *
 * www.cctv.com
 *
 * www.huawei.com
 *
 * www.cctv.com
 *
 * www.huawei.com
 *
 * www.cctv.com
 *
 * www.huawei.com
 *
 * 3
 *
 * 输出
 *
 * news.qq.com,game.163.com,news.sina.com.cn
 *
 * www.huawei.com,www.cctv.com,news.qq.com
 *
 * 示例2
 * 输入
 *
 * news.qq.com
 *
 * www.cctv.com
 *
 * 1
 *
 * www.huawei.com
 *
 * www.huawei.com
 *
 * 2
 *
 * 3
 *
 * 输出
 *
 * news.qq.com
 *
 * www.huawei.com,news.qq.com
 *
 * www.huawei.com,news.qq.com,www.cctv.com
 *
 * 解题思路：
 * 使用map键值对，key值对应网站名，value值记录访问次数
 *
 * 对map进行排序，找出value值排前N的网站
 */
public class 热点网站统计 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);//热点网站统计
        Map<String,Integer> map = new HashMap<>();
        while (sc.hasNext()){
            String str = sc.nextLine();
            if(!str.contains(".")){ //不包含.的就是数字
                int n = Integer.parseInt(str);
                if(n>map.size()){   //如果数字大于网站个数这退出
                    break;
                }
                List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet()); //将map转换成list
                String res = "";
                list.sort((a,b)->{  //对list进行降序排序
                    if(b.getValue()<a.getValue()){
                        return -1;
                    }
                    return 1;
                });
                for(int i=0; i<n; i++){
                    res+=list.get(i).getKey();
                    if(i!=n-1){
                        res += ",";
                    }
                }
                System.out.println(res);
            }else {
                map.put(str, map.getOrDefault(str,0)+1);
            }
        }
    }
}
