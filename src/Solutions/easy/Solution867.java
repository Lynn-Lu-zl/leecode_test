package Solutions.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * -109 <= matrix[i][j] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution867 {
    /**
     * 本题的矩阵的行列数可能不等，因此不能做原地操作，需要新建数组
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        //新建数组
        int[][] res = new int[N][M];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                //转置，相当于对角线对折
                res[j][i] = matrix[i][j];
            }
        }
        return res;

    }
    
     public static void main(String[] args) {

         Solution867 solution867 = new Solution867();
         //[[I@1b6d3586, [I@4554617c, [I@74a14482]
         int[][] ints = {
             {1, 2, 3},
             {4, 5, 6},
             {7, 8, 9}};

         System.out.println(Arrays.toString(solution867.transpose(ints)));
     }
}
