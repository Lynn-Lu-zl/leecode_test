package huawei.real.score100;

import java.util.Scanner;

/**
 * 为了充分发挥GPU算力，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，数组元素表示在这1秒内新增的任务个数且每秒都有新增任务，假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成
 * 输入描述:
 * 第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
 * 第二个参数为任务数组长度，取值范围[1, 10000]
 * 第三个参数为任务数组，数字范围[1, 10000]
 * 输出描述:
 * 执行完所有任务最少需要多少秒
 * 示例1
 * 输入
 * 3
 * 5
 * 1 2 3 4 5
 * 输出
 * 6
 * 说明
 * 一次最多执行3个任务，最少耗时6s
 * 示例2
 * 输入
 * 4
 * 5
 * 5 4 1 1 1
 * 输出
 * 5
 * 说明
 * 一次最多执行4个任务，最少耗时5s
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124558394
 */
public class 执行时长 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bing = Integer.parseInt(sc.nextLine());
        int times = Integer.parseInt(sc.nextLine());
        String[] inputs = sc.nextLine().split(" ");
        int left = 0;
        for (int i = 0; i < times; i++) {
            int th = Integer.parseInt(inputs[i]);
            left = Math.max(0,left + th - bing);

        }
        int res = times;
        if (left % bing == 0){
            res += left / bing;
        }else {
            res += left / bing + 1;
        }
        System.out.println(res);
    }

}
