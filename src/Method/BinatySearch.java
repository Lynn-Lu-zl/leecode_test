package Method;

import java.util.Arrays;

/**
 * 二分查找法/折半查找法
 */
public class BinatySearch {


    //遍历查找
    public static int search(int[] nums, int key){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key){
                return 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 猜数问题
     * 参数：数组 arraynum  目标数target
     * 返回结果：int整数，
     *      空数组/数组长度为0/目标值不存在：-1
     *      目标值存在：数组下标/索引
     *
     *查找区间：[左指针，右指针]
     *左指针 left：从数组第一个元素下标为0开始
     *右指针 right：从数组最后一个元素下标为数组长度-1开始
     *数组中间元素下标 mid： left+(right-left)/2，int整数取整 如数组长度10，下标从0-9，计算0+(9-0)/2=4.5=4即数组第5个元素
     *
     * 判断中间元素和目标值关系
     *
     */
    public static int halfnum(int[] arraynum, int target){
        //左指针，数组第一个元素，下标从0开始
        int left=0;
        //右指针，数组最后一个元素，下标为数组长度-1
        int right=arraynum.length-1;

       //特殊情况，返回-1
       if (arraynum==null || arraynum.length==0){
           return -1;
       }

        while (right >= left ){
           //计算数组中间元素的下标，int类型有小数点取整
           int mid = left+(right-left)/2;
           //判断中间元素和目标值关系
            //1、目标值等于中间元素，返回中间元素的下标
            if ( target == arraynum[mid]){
                return mid;
            }
            //2、目标值小于中间元素，缩减右半区，右指针移动到中间元素坐标前一位
            else if ( target <arraynum[mid] ){
                right=mid-1;
            }
            //3、目标值大于中间元素，缩减左半区，左指针移动到中间元素坐标后一位
            else if ( target > arraynum[mid]){
                left=mid+1;
            }

        }
        //遍历数组都没有找到目标值，跳出循环，返回-1
        return -1;
    }

     public static void main(String[] args) {
         //Method.BinatySearch binatySearch = new Method.BinatySearch();
         //目标数组
         int[] nums={2,4,5,7,9,11,12,15,16,17};
         //目标值
         int target = 5;
         int key=1;
         //遍历查找
         //System.out.println(search(nums, key));
         //二分查找
         System.out.println("目标数组："+ Arrays.toString(nums));
         System.out.println("目标值：" + target);
         System.out.println("目标值的数组下标："+halfnum(nums, target));


     }
}
