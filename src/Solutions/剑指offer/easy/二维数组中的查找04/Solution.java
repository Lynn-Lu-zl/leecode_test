package Solutions.剑指offer.easy.二维数组中的查找04;

/**
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *  
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 法一，暴力枚举
     * 遍历两层
     * 将目标值和二维数组中的每个元素值进行比较，看看是否存在相等的元素
     *
     *
     *
     * 时间复杂度是 O(n^2)
     * 空间复杂度是 O(1)
     * @param matrix
     * @param target
     * @return
     */
    // public boolean findNumberIn2DArray(int[][] matrix, int target) {
    //     //一维
    //     int m = matrix.length;
    //      if (m == 0){
    //         return false;
    //     }
    //     //二维,matrix[0,1,2,3],
    //     int n = matrix[0].length;
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] == target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }


    /**
     * 利用左右有序的特点
     * 矩阵中每一行的元素都是升序排列的，对每一行都使用一次二分查找，判断target 是否在该行中，从而判断target 是否出现
     * 数组的每一行和每一列都是有顺序的,在一个排好序的数组中查找目标值是否存在--》二分查找
     * 时间复杂度是 O(nlog(m))
     * 空间复杂度是 O(1)
     * @param matrix
     * @param target
     * @return
     */
    // public boolean findNumberIn2DArray(int[][] matrix, int target) {
    //
    //     for (int[] row : matrix) {
    //         int searchNum = search(row, target);
    //         if (searchNum > 0){
    //             return false;
    //         }
    //     }
    //     return false;
    // }
    //
    //
    // public int search(int[] nums,int target){
    //     int
    //     return -1;
    // }


    /**线性查找
     * 从上到下递增、从左到右递增--》每个角都是最值--》
     * 左下角的元素值大于它上面的元素，而小于它右边的元素
     * 右上角的元素值大于它左边的元素，而小于它下面的元素
     *
     * 从左下角的坐标开始--》只能往右走/往上走
     * 因为左下角的元素值大于它上面的元素，而小于它右边的元素--》
     * 1、先找到目标对象所在的行
     * 目标值比左下角元素小--》目标值横坐标在左下角元素的上边--》往上移1--》横坐标-1
     * 2、再找到目标对象 所在列
     * 目标值比左下角元素大--》目标值横坐标在左下角元素的右边--》往右移1--》横坐标+1
     *
     *
     *
     *
     * [-->列column  一共5列
     *    0     1   2  3   4
     * 0  [1,   4,  7, 11, 15],
     * 1  [2,   5,  8, 12, 19],
     * 2  [3,   6,  9, 16, 22],
     * 3  [10, 13, 14, 17, 24],
     * 4  [18, 21, 23, 26, 30]
     *   |
     *   v  row行  一共5行
     *
     *   左下角18坐标 (4,0) 横坐标4=row-1,纵坐标0
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 时间复杂度 O(M+N)：其中，NN 和 MM 分别为矩阵行数和列数，此算法最多循环 M+NM+N 次，N*M是常数可忽略？
     * 空间复杂度 O(1) : i, j 指针使用常数大小额外空间。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return false;
        }
        
        //一共有多少行，5
        int row = matrix.length;
        //一共多少列，5
        int column = matrix[0].length;

        //左下角18坐标 (4,0) 行坐标4=row-1,列坐标0
        
        //左下角列坐标4，上下
        int upIndex = row - 1;
        //左下角行坐标0，左右
        int rightIndex = 0;

        //从最左下角的元素出发，根据和目标元素比大小决定往右移还是往上移
        while (upIndex >= 0 && rightIndex < column){

            //target=当前元素坐标--》true
            if (matrix[upIndex][rightIndex] == target){
                return  true;
            }else if (matrix[upIndex][rightIndex] < target){
                //从左往右越来越大--》当前元素小于目标元素--》目标元素在右边
                //向右走-》行坐标+1
                rightIndex++;
            }else if (matrix[upIndex][rightIndex] > target){
                //从下往上越来越小--当前元素大于目标元素--》目标元素在上边
                //向上走--》列坐标-1
                upIndex--;
            }
        }
        return false;
    }


     public static void main(String[] args) {

        /*int[][] arr3 = new int[3][3];
		arr[0][0] = 10;
		arr[0][1] = 20;
		arr[0][2] = 30;
		arr[1][0] = 40;
		arr[1][1] = 50;
		arr[1][2] = 60;
		arr[2][0] = 70;
		arr[2][1] = 80;
		arr[2][2] = 90;*/

         int[][] matrix = {
             {10,20,30,100},
             {40,50,60,110},
             {70,80,90,120}
         };
         Solution solution = new Solution();
         System.out.println(solution.findNumberIn2DArray(matrix, 90));
     }

}
