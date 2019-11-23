package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;

public class ExtendsTest extends TestFathor {

    public ExtendsTest() {
        super(1, 2, 3, "ss", "ssd", "dfs");
    }

    @Override
    public void init() {

    }

    @Override
    public void handler() {
        System.out.println("这是handler方法");
        System.out.println("这是继承父类的属性：" + super.toString());
    }
}
