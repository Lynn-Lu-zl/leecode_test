package JavaTest;

/**
 * final关键字
 *
 * 1、final修饰的类无法继承
 *  class FinalTest extends String (x)，无法继承String类
 *
 * 2、final 修饰的方法无法被子类重写，但是可以被重载
 *
 * 3、被final修饰的变量，必须在初始化的时候就赋值，只能赋值一次，后面不能修改该初始化的值
 *
 * （1） 成员变量：
 *   一次赋值，终生不变
 *
 * 一般成员变量都有默认的初始值--》final修饰的成员变量必须手动初始化，不能采用JVM虚拟机默认值
 *
 * final修饰的实例变量一般和static联合使用--》变成类常量，可以不用创建类直接引用，用大写字母和下划线表示，这是一种编码规定
 *
 * 例如 public static final double PI = 3.1415926;
 *
 * （2）局部变量
 * 对于基本类型--》不可改变指的是变量的数据不能改变
 *
 * 对于引用类型--》不可改变指的是引用对象当中的地址值不可改变，但是引用对象内部的数据可以改变
 *
 * 4、对于类、方法来说，final和abstract两个关键词是对立的，不能共存，因为他们的目的相反，声明为抽象就是为了让子类去重写它，但是final就是希望子类不去重写它
 *  abstract final class FinalTest(x)
 *
 * 5、
 */
public class FinalTest {

    //报错，没有赋值
    //private final int finalValue2 ;
    //被final修饰的成员变量，必须在初始化的时候就赋值，只能赋值一次，后面不能修改该初始化的值
    private final int finalValue = 5;

    //普通成员变量，有初始化默认值，可以不赋值
    private int normalValue;
    private int value = 10;

    //final修饰的实例变量一般和static联合使用，称为类常量，可以不用创建类直接引用，用大写字母和下划线表示，这是一种编码规定
    private static final double PI = 3.1415926;


    /**
     * 被final 修饰的方法
     * 子类不能重写该方法
     * 可以被本类重载
     */
    public final void cannotOverride(){
        System.out.println("子类不能重写final 修饰的方法");
    }

    public final void cannotOverride(int value){

        System.out.println("final修饰的方法可以被重载");
    }

    /**
     * 普通方法子类可以重写
     */
    public void canOverride(){
        //修饰局部变量
        //对于基本类型--》不可改变指的是变量的数据不能改变
        final int value =1;
        int normalValue=10;
        //报错，被final修饰局部变量的数据不能改变
        //System.out.println(value=40);
        //无报错，一般的局部变量的数据能改变
        System.out.println(normalValue=1);

        //对于引用类型--》不可改变指的是引用对象当中的地址值不可改变，但是引用对象内部的数据可以改变
        FinalSonTest finalSon = new FinalSonTest();
        FinalSonTest finalSonTest2 = new FinalSonTest();
        //被final修饰局部变量,类型为引用类型
        final FinalSonTest finalSonTest = new FinalSonTest();
        //报错，被final修饰局部变量如果类型为引用类型，引用对象当中的地址值不可改变
        //finalSonTest = finalSon;
        //无报错，一般引用对象地址值可改变
        finalSonTest2 = finalSon;
        //将FinalSonTest成员变量的值改变了无报错
        finalSonTest.norVal = 100;
        System.out.println(finalSonTest.norVal);

        System.out.println("子类可以重写的方法");
    }

     public static void main(String[] args) {
         FinalTest finalTest = new FinalTest();

         //报错，只能在初始化的赋值，不能重新赋值
         //finalTest.finalValue = 10;
         //报错，不可以引用其他变量的值
         //finalTest.finalValue = finalTest.value;

         //无报错，普通变量可以引用其他变量的值
         finalTest.normalValue = finalTest.value;

         System.out.println(finalTest.finalValue);
         System.out.println(finalTest.normalValue);

         //final修饰的实例变量一般和static联合使用，称为常量
         System.out.println(PI);

         //调用
         finalTest.canOverride();

     }

}


class FinalSonTest extends FinalTest{

    public int norVal;
    /**
     * 报错，不能重写父类的final方法
     */
    // @Override
    // public final void cannotOverride(){
    //     System.out.println("我是子类，我不能重写父类final修饰的方法");
    // }

    @Override
    public void canOverride() {
        System.out.println("我可以重写父类的非final方法");
    }


     public static void main(String[] args) {
         FinalSonTest finalSonTest = new FinalSonTest();
         finalSonTest.canOverride();
     }
}
