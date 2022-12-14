package huawei.real.score100;

import java.util.*;

/**
 * 有一个简易内存池，内存按照大小粒度分类，每个粒度有若干个可用内存资源，用户会进行一系列内存申请，需要按需分配内存池中的资源，返回申请结果成功失败列表。分配规则如下：
 * 1、分配的内存要大于等于内存申请量，存在满足需求的内存就必须分配，优先分配粒度小的，但内存不能拆分使用--》意思是它需要50k内存不能给它128k规格的，就给最近的64k规格
 * 2、需要按申请顺序分配，先申请的先分配。
 * 3、有可用内存分配则申请结果为true，没有可用内存分配则返回false。
 * 注：不考虑内存释放。
 * 输入描述:
 * 输入为两行字符串：
 * 第一行为内存池资源列表，包含内存粒度数据信息，粒度数据间用逗号分割，一个粒度信息内部用冒号分割，冒号前为内存粒度大小，冒号后为数量。资源列表不大于1024，每个粒度的数量不大于4096
 * 第二行为申请列表，申请的内存大小间用逗号分隔。申请列表不大于100000
 * 如：
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 输出描述:
 * 输出为内存池分配结果。
 * 如：
 * true,true,true,false,false
 * 示例1
 * 输入
 * 64:2,128:1,32:4,1:128
 * 50,36,64,128,127
 * 输出
 * true,true,true,false,false
 * 说明
 * 内存池资源包含：64K共2个、128K共1个、32K共4个、1K共128个的内存资源；
 * 针对50,36,64,128,127的内存申请序列，分配的内存依次是：64,64,128,NULL,NULL,第三次申请内存时已经将128分配出去，
 * 因此输出结果是：true,true,true,false,false
 * ————————————————
 * 版权声明：本文为CSDN博主「旧梦昂志」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/csfun1/article/details/124516351
 */
public class 内存资源分配 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        String[] apply = sc.nextLine().split(",");
        List<Integer> exist = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            String[] typeCount = input[i].split(":");
            int type = Integer.parseInt(typeCount[0]);
            exist.add(type);
            map.put(type,Integer.parseInt(typeCount[1]));
        }
        Collections.sort(exist);
        for (int i = 0; i < apply.length; i++) {
            boolean flag = false;
            int need = Integer.parseInt(apply[i]);
            for (int j = 0; j < exist.size(); j++) {
                if (need<= exist.get(j)){
                    //拿出来一个
                    int pool = map.get(exist.get(j));
                    flag = true;
                    if (--pool == 0){
                        map.remove(exist.get(j));
                        exist.remove(j);
                    }else {
                        map.put(exist.get(j),pool);
                    }
                    break;
                }
            }
            System.out.print(flag + " ");
        }
        // System.out.println();
    }

}
