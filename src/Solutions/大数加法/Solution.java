package Solutions.大数加法;

public class Solution {

    /**
     * 模拟竖式加法
     * 8 6 0 4 3
     *   5 5 8 2
     *-----------
     * 9 1 6 2 5
     *
     * 两个字符串从低位开始相加，当前位置和超过10则向高位进位
     *
     * i：字符串s的低位，即从最右边的个位开始
     * j:字符串t的低位，即从最右边的个位开始
     * count:进位，如果两数之和>10，count+1表示进了位
     * 每次相加的结果res = count + s.char(i) + t.char(j)
     * @param s
     * @param t
     * @return
     */
    public String solve (String s, String t) {

        StringBuilder sb = new StringBuilder();
        //s的低位，即从最右边的个位开始
        int i = s.length() - 1;
        //字符串t的低位
        int j = t.length() -1;
        //进位数，一旦不为0说明当前位之和>10，count+1
        int count = 0;
        while (i >=0 || j>=0 ||count != 0){
            //如果
            int x = i >= 0 ? s.charAt(i) - '0' : 0;
            int y = j >= 0 ? t.charAt(j) - '0' : 0;
            //每次当前位相加的结果res = count + s.char(i) + t.char(j)，4+8+上一次循环留下的count有没有进高位=12
            int res = x + y + count;

            //记录当前位之和的个位数，追加到字符串上，如4+8=12%10=2，
            sb.append(res % 10);
            //记录进位数，如果当前位之和>10--》12/10=1则count会变成1，在下次循环时会加到高位上
            count = res / 10;
            //低位完成两个步骤后，往左边移动进行下一个高位相加
            i --;
            j --;
        }
        //反转，因为是从低位之和开始追加的，所得字符串结果是相反的
        sb.reverse();
        return sb.toString();
    }

     public static void main(String[] args) {

         Solution solution = new Solution();
         // String s="114514";
         // String t="123454785";
         String s="1111";
         String t="1222";
         System.out.println(solution.solve(s, t));
     }

}
