package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;

public class ExtendsTest extends TestFathor {
     protected  int anInt = 12;

    /**
     * 静态方法
     * */
    static {
        logger.info("ExtendsTest静态代码块开始");
        int intattr1 = 22;
        String strAttr1 = "这是静态代码块中的一个属性intattr1：" + intattr1;
        logger.info(strAttr1);
        logger.info("这是ExtendsTest的静态方法!");
        logger.info("ExtendsTest静态代码块结束");
    }

    /**
     * 非静态代码块
     * */
    {
        logger.info("ExtendsTest非静态代码块开始");
        int intattr1 = 11;
        String strAttr6 = "这是非静态代码块中的一个属性intattr1：" + intattr1;
        logger.info(strAttr6);
        logger.info("这是ExtendsTest的非静态代码块");
        logger.info("ExtendsTest非静态代码块结束");
    }

    public ExtendsTest() {
        logger.info("这是ExtendsTest的构造方法!");
    }

    @Override
    public void init() {
        //logger.info("这是ExtendsTest的非静态参数strAttr1 ： " + ExtendsTest.strAttr1);

    }

    @Override
    public void handler() {
        System.out.println("这是ExtendsTest的handler方法");
    }
}
