package Solutions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : nums) {
            set.add(num);
        }

        //因为num的取值范围是1-n，要排除0，所以i从1开始--》遍历数组长度因为i从1开始少了1所以要加上nums.length+1
        for (int i = 1; i < nums.length+1; i++) {
            if ( ! set.contains(i)){
                list.add(i);
            }
        }
        return list;



    }

     public static void main(String[] args) {
         Solution448 solution448 = new Solution448();
         // int[] ints = {4, 3, 2, 7, 8, 2, 3, 1};
         int[] ints = {1,1};
         System.out.println(solution448.findDisappearedNumbers(ints));

     }
}
