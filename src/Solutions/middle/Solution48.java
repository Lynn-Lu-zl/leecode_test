package Solutions.middle;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。

 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

  

 示例 1：


 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[[7,4,1],[8,5,2],[9,6,3]]
 示例 2：


 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

 来源：力扣（LeetCode）
 链接：https://leetcode.cn/problems/rotate-image
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 *
 * 矩阵旋转可以转换成对折的方式；
 * 旋转90度：对角线对折后，竖中线对折；
 * 旋转180度：横中线对折后，竖中线对折；或竖中线对折后横中线对折；
 * 旋转270度：对角线对折后，横中线对折；
 *
 */
public class Solution48 {

    public void rotate(int[][] matrix) {
        //解题思路：矩阵旋转可以转换成对折的方式；
        //旋转90度：对角线对折后，竖中线对折；
        //旋转180度：横中线对折后，竖中线对折；或竖中线对折后横中线对折；
        //旋转270度：对角线对折后，横中线对折；
        int n = matrix.length;
        int temp = 0;


        //对角线对折，转置
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //竖中线对折
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

    }
     public static void main(String[] args) {
         Solution48 solution48 = new Solution48();
         int[][] ints = {
             {1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}};
         solution48.rotate(ints);
     }
}
