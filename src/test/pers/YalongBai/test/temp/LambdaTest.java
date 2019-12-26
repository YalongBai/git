package test.pers.YalongBai.test.temp;

import test.pers.YalongBai.test.handler.LambdaInterfaceImpl;
import test.pers.YalongBai.test.utils.LambdaInterface;

import java.rmi.activation.ActivationGroup_Stub;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author 白亚龙
 * @time 2019年12月14日20:58:28
 * @deprecated Lambda表达式--函数式编程
 * 或称函数程序设计，又称泛函编程，是一种编程典范，它将电脑运算视为数学上的函数计算，并且避免使用程序状态以及易变对象。
 * 函数编程语言最重要的基础是λ演算（lambda calculus）。而且λ演算的函数可以接受函数当作输入（引数）和输出（传出值）。比起指令式编程，
 * 函数式编程更加强调程序执行的结果而非执行的过程，倡导利用若干简单的执行单元让计算结果不断渐进，逐层推导复杂的运算，而不是设计一个复杂的执行过程。
 * 这是维基百科给出的定义。从这个我们知道函数式编程是相对于指令式编程的一种编程典范，并且对而言具有一些优点。
 * 优点：
 *
 *     1、代码简洁，开发快速。
 *     2. 接近自然语言，易于理解
 *     3. 更方便的代码管理
 *     4. 易于"并发编程"
 *     5. 代码的热升级
 *  缺点：
 *      1、函数式编程常被认为严重耗费在CPU和存储器资源。
 *      2、语言学习曲线陡峭，难度高
 * 表达式由三个部分组成：第一部分为一个括号内用逗号分隔的形式参数，参数是函数式接口里面方法的参数；第二部分为一个箭头符号：->；第三部分为方法体，可以是表达式和代码块。
 *
 */
public class LambdaTest {

    // lambda测试案例一  利用函数式接口输出信息
    private static void  show(LambdaInterface lambdaInterface){
        lambdaInterface.doLambda();
    }

    // lambda测试案例二  利用函数式编程作为参数，实现Runnable线程
    private static void startThread(Runnable run) {
        new Thread(run).start();
    }

    // lambda测试案例三-一  利用匿名内部类作为返回值
    private static Comparator<String> getCompare1(){
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
    }

    // lambda测试案例三-二  利用lambda作为返回值
    private static Comparator<String> getCompare2() {
        return (o1, o2) ->   o2.length() - o1.length();
    }

    public static void main(String[] args) {
        /**#####################################
        // 1 执行继承类
        show(new LambdaInterfaceImpl());
        // 2 执行匿名内部类
        show(new LambdaInterface() {
            @Override
            public void doLambda() {
                System.out.println("利用匿名内部类执行doLambda()");
            }
        });
        // 3 利用lambda执行
        show(()->{
            System.out.println("利用lambda执行doLambda()");
        });
         #####################################*/
        /**#####################################
        // 利用匿名内部类实现
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(  Thread.currentThread().getName() + "=> 线程启动了");
            }
        });
        // 利用lambda实现
        startThread(()->{
            System.out.println( Thread.currentThread().getName() + "=> 线程启动了");
        });
         #####################################**/

        String[] arr = {"Thread", "out", "System" , "startThread"};
        System.out.println("原始：" + Arrays.toString(arr));
        Arrays.sort(arr, getCompare1());
        System.out.println("第一次排序：" + Arrays.toString(arr));
        Arrays.sort(arr, getCompare2());
        System.out.println("第二次排序" + Arrays.toString(arr));

        Arrays.stream(arr)
                .filter(value->value.startsWith("T"))
                .forEach(value-> System.out.println( "stream过滤：" + value));
        Map<String , Object> map = new HashMap<String , Object>();
        Stream<Map<String, Object>> stream = Stream.of(map);
    }
}
