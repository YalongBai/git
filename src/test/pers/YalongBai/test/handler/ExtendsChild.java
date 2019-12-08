package test.pers.YalongBai.test.handler;

public class ExtendsChild  extends ExtendsTest{

    {
        anInt = 55;
    }

    /**
     * 静态代码块
     * */
    static {
        logger.info("ExtendsChild静态代码块开始");
        int intattr11 = 12;
        String strAttr11 = "这是静态代码块中的一个属性intattr1：" + intattr11;
        logger.info(strAttr11);
        logger.info("这是ExtendsChild的静态代码块!");
        logger.info("ExtendsChild静态代码块结束");
    }

    /**
     * 非静态代码块
     * */
    static {
        logger.info("ExtendsChild非静态代码块开始");
        int intattr11 = 12;
        String strAttr11 = "这是静态代码块中的一个属性intattr1：" + intattr11;
        logger.info(strAttr11);
        logger.info("这是ExtendsChild的非静态代码块!");
        logger.info("ExtendsChild非静态代码块结束");
    }

    /**
     * 构造方法
     * */
    public ExtendsChild() {
        //logger.info(this.strAttr11);
        logger.info("这是ExtendsChild的构造方法！");
        logger.info("anInt = " + anInt);
        logger.info("super.anInt = " + super.anInt);
    }

    @Override
    public void handler(){
        System.out.println("这是ExtendsChild的handler方法");
    }



}
