package Sort;

/**
 * 快速排序
 * 随机取一个值作为基准（一般去做下标），对数组的值分为大于和小于基准两部分，然后采用递归的方式全部使得数组有序。
 */
public class QuickSort {

    public static void quickSort(int []nums,int l,int r){
        if(l<r){
            int index=partition(nums,l,r);
            //分治递归
            quickSort(nums,l,index-1);
            quickSort(nums,index+1,r);
        }
    }
    // partition就是让按照基准划分两部分
    public static int partition(int []nums,int l,int r){
        int flag=l;//标识
        int index=l+1;//标识右部分的初始位置
        for(int i=index;i<=r;i++){
            if(nums[i]<nums[flag]){
                // 交换
                swap(nums,i,index);
                index++;
            }
        }
        //将flag和前半部分最后一个进行交换
        swap(nums,index-1,flag);
        // index-1是标识的下标
        return index-1;
    }
    public static  void swap(int [] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }

     public static void main(String[] args) {

         }
}
