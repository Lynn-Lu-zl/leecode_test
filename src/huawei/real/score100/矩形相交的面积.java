package huawei.real.score100;

import java.util.Scanner;

/**
 * https://f.daixianiu.cn/csdn/3680253646799698.html
 *
 * 在坐标系中，给定3个矩形，求相交区域的面积。
 *
 * 输入描述:
 *
 * 3行输入分别为3个矩形的位置，分别代表
 *
 * ‘左上角x坐标’，‘左上角y坐标’，‘矩形宽’，‘矩形高’
 *
 * -1000 <= x,y < 1000
 *
 * 输出描述:
 *
 * 输出3个矩形相交的面积，不相交的输出0
 *
 * 示例1
 * 输入：
 *
 * 1 6 4 4
 *
 * 3 5 3 4
 *
 * 0 3 7 3
 *
 * 输出：
 *
 * 2
 *
 * 说明：
 *
 * 给定3个矩形A，B，C
 *
 * A：左上角坐标(1, 6)，宽4，高4
 *
 * B：左上角坐标(3, 5)，宽3，高4
 *
 * C：左上角坐标(0, 3)，宽7，高3
 *
 * 3个矩形的相交面积为2，如图所示：
 * https://img-blog.csdnimg.cn/a3eed74ff9e04676935c68c478174862.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA6Iul5Y2a6LGG,size_16,color_FFFFFF,t_70,g_se,x_16
 */
public class 矩形相交的面积 {
    public static void main(String[] args) {
        //矩形相交的面积，‘左上角x坐标’，‘左上角y坐标’，‘矩形宽’，‘矩形高’
        Scanner sc = new Scanner(System.in);

        int[] a = new int[4];
        int[] b = new int[4];
        int[] c = new int[4];

        for(int i=0;i<4;i++){
            a[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++){
            b[i] = sc.nextInt();
        }
        for(int i=0;i<4;i++){
            c[i] = sc.nextInt();
        }

        int top = Math.min(a[1],Math.min(b[1],c[1]));       //上边界为三个坐标Y轴坐标的最小值
        int left = Math.max(a[0],Math.max(b[0],c[0]));      //左边界为三个坐标X轴坐标的最大值
        int down = Math.max(a[1]-a[3],Math.max(b[1]-b[3],c[1]-c[3]));       //下边界为三个坐标（Y轴坐标-高度）的最大值
        int right = Math.min(a[0]+a[2],Math.min(b[0]+b[2],c[0]+c[2]));      //右边界为三个坐标（X轴坐标+宽度）的最小值

        int res = (top-down)*(right-left);      //高为（上边界-下边界）*宽为（右边界-左边界）

        System.out.println(res);

    }

}
