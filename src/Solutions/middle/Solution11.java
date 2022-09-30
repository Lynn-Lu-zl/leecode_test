package Solutions.middle;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class Solution11 {
    // public int maxArea(int[] height) {
    //
    //     int i = 0,
    //         j = height.length - 1,
    //         max = 0,
    //         res = 0;
    //     while(i < j){
    //
    //         max = height[i] < height[j] ? (j - i) * height[i++] : (j - i) *height[j--];
    //
    //         res = Math.max(res, max);
    //     }
    //     return res;
    //
    //
    // }


    /**
     * 双指针
     * @param
     */
    public int maxArea(int[] height) {
        //左指针索引
        int left = 0;
        //给的是长度为n的数组，索引：0-(n-1)，右指针索引值=数组的长度-1
        int right = height.length - 1;
        //记录的最大面积
        int maxArea = 0;

        while (left <= right) {
            //左右指针在最左右边，怎么样移动才能获取最大面积--》移动两个里面高度更小的指针，高度较小的那个先中间移动
            //计算面积=长 * 宽，宽=右指针-左指针，长是给出的数组值中取最小值
            int area = Math.min(height[left], height[right]) * (right - left);
            //更新最大面积
            maxArea = Math.max(maxArea, area);
            //如果左指针对应的高度比右指针小
            if (height[left] < height[right]) {
                //左指针右移
                left++;
            }
            else {
                right--;
            }

        }
        return maxArea;



    }

    public static void main(String[] args) {
         Solution11 solution11 = new Solution11();
         //高度
         int[] ints = {1,8,6,2,5,4,8,3,7};
         System.out.println(solution11.maxArea(ints));
     }
}
