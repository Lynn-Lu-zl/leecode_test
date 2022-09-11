package DataStructure;

import java.util.Objects;

public class Test {


    private final int value;
    public Test(int value) {
        this.value = value;
    }

    //包装类Integer内部重写的equals方法源码
    // @Override
    // public boolean equals(Object obj) {
    //     if (obj instanceof Integer) {
    //         //拆箱比较，将它转为基本数据类型再用==比较
    //         return value == ((Integer)obj).intValue();
    //     }
    //     return false;
    // }

    //自己重写equals方法，变成值比较
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return value == test.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public static void main(String[] args) {
         Object o = new Integer(1);
         Object o1 = new Integer(1);
        Object o2 = new Object();
        Object o3 = new Object();
        int i =0;
         int p =0;
         //“==”如果是基本数据类型则比较值，返回true
         System.out.println(i == p);
         //不是基本数据类型不能用equals方法
         //System.out.println(i.equals(p));
         //“==”如果是引用类型则比较引用地址，返回false
         System.out.println(o == o1);

         //包装类内部已经重写了equals方法，哪怕不在该类重写equals方法比较的也是值，返回true
         System.out.println(o.equals(o1));

        //equals只能是引用类型用，其实该方法内部也是调用了“==”的方法，所以也是比较地址，只要不是同一个创建的对象比较都会为false，但提供该方法的原因是给人可以重写该方法用于两个对象之间可以进行值比较的，如String、基本类型的包装类都会重写equals让他们可以变成对象和对象之间只比较值
        System.out.println(o2.equals(o3));



    }
}
