package huawei.real.score200;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**有人考过
 * 欢乐的周末
 * 小华和小为是很要好的朋友，他们约定周末一起吃饭通过手机交流，
 * 他们在地图上选择了多个聚餐地点（由于自然地形等原因，部分聚餐地点不可达)，
 * 求小华和小为都能到达的聚餐地点有多少个?
 *
 * 输入描述:
 * 第一行输入m和n,m代表地图的长度，n代表地图的宽度。第二行开始具体输入地图信息，
 * 地图信息包含:
 * 0为通畅的道路
 * 1为障碍物(旦仅1为障碍物)
 * 2为小华或者小为，地图中必定有且仅有2个(非障碍物)
 * 3为被选中的聚餐地点(非障碍物)
 */
public class FunnyWeeks {
    private static final int N = 110;
    private static int[][] arr = new int[N][N];
    private static Map<String, Integer> map1 = new HashMap<>(),map2 = new HashMap<>();
    private static int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};
    private static int n, m;

     public static void main(String[] args) {
         Scanner cin = new Scanner(System.in);
         n = cin.nextInt();
         m = cin.nextInt();
         int[] pos = new int[4];
         for (int i = 0,k = 0; i < n; i++) {
             for (int j = 0; j < m; j++) {
                 arr[i][j] = cin.nextInt();
                 if(arr[i][j] == 2) {
                     pos[k++] = i;
                     pos[k++] = j;
                 }
             }
         }
         dfs(pos[0],pos[1],map1);
         dfs(pos[2],pos[3],map2);
         int res = 0;
         if(map1.size() == 0 || map2.size() == 0) System.out.println(0);
         else {
             for(Map.Entry<String,Integer> entry : map1.entrySet()) {
                 String key = entry.getKey();
                 if(map2.containsKey(key)) res++;
             }
             System.out.println(res);
         }
     }

    private  static void dfs(int x, int y,Map<String,Integer> map) {
        if (arr[x][y] == 3) {
            String key = get(x,y);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        int k = arr[x][y];
        arr[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int a = dx[i] + x, b = dy[i] + y;
            if (a >= 0
                && a < n
                && b >= 0
                && b < m
                && arr[a][b] != 1
                && arr[a][b] != -1
                && !map.containsKey(get(a,b))
                ) {
                dfs(a, b,map);
            }
        }
        arr[x][y] = k;
    }
    public static String get(int x,int y) {
        return  String.valueOf(x) + "@" + String.valueOf(y);
     }
}
