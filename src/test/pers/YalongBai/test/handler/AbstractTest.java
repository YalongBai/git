package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;

/**
 * @author 白亚龙
 * 2019年11月24日09:40:23
 * java抽象属性测试类
 * 抽象类特征：用abstract修饰，TestFather为抽象类
 *
 */
public class AbstractTest extends TestFathor {

    static {
        logger.info("这是AbstractTest静态代码块");
    }

    public AbstractTest() {
        logger.info("这是AbstractTest的构造方法！");
    }

    @Override
    protected void init() {

    }

    @Override
    protected void handler() {

    }

    /**
     * 抽象类注意细节
     *
     * */
    public  abstract  class demo{
       // 抽象类不能与private 、 final、 static关键字共用
        //
    }
}
