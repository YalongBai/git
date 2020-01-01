package target;

import test.pers.YalongBai.test.handler.*;
import test.pers.YalongBai.test.utils.Logger;

import java.io.File;

public class myTest {
    public static void main(String args[]){
        Logger logger = Logger.getInstance();

        // 继承测试类
       /* ExtendsChild test1 = new ExtendsChild();
        test1.init();
        System.out.println(test1.logger);
        // 多态测试类
        ExtendsTest extendsTest = new ExtendsChild();
        extendsTest.handler();
        // 多态测试类
        PolymorphicTest polymorphicTest = new PolymorphicTest();
        polymorphicTest.handler();*/
        /**
         * 单例测试
         * 1. 静态常量单例
         * 2. 静态代码单例
         * 3. 饿汉式（不安全测试）
         * 4. 饿汉式（同步关键字）
         * 5. 饿汉式（双重校验）
         * 6. 内部静态类*/
        /*
        logger.info("单例测试");
        Object object = SingleTonTest.getInstance("SingleTon");
        logger.info(object.getClass());
        Object object1 = SingleTonTest.getInstance("SingleTon1");
        logger.info(object1.getClass());
        Object object2 = SingleTonTest.getInstance("SingleTon2");
        logger.info(object2.getClass());
        Object object3 = SingleTonTest.getInstance("SingleTon3");
        logger.info(object3.getClass());
        Object object4 = SingleTonTest.getInstance("SingleTon4");
        logger.info(object4.getClass());
        Object object5 = SingleTonTest.getInstance("SingleTon5");
        logger.info(object5.toString());
        object5 = SingleTonTest.getInstance("SingleTon5");
        logger.info(object5);*/


        /**
         * 反射测试
         */
        /*ReflectTest reflectTest = new ReflectTest();
        reflectTest.init("java.io.File");
        reflectTest.showClass();
        //reflectTest.handler();*/
        /**
         * IO流测试
         * 1 File类测试
         */
        /*IOTest test = new IOTest();
        test.fileTest("./src/target/myTest.txt", "./src/resource/test/pers/YalongBai/test/test1.txt");
        test.deletFile("./src/resource/test/pers/YalongBai/test/test1.txt");
        test.handler();*/
        /*ThrowableTest throwable = new ThrowableTest();
        throwable.handler();*/
        /**
         * 数组测试
         * */
        /*ArraySortTest sortTest = new ArraySortTest();
        sortTest.init();
        sortTest.handler();*/
        /**
         * （非）公平锁测试
         */
        LockTest lockTest = new LockTest();
        lockTest.reentrantLockTest();


    }
}
