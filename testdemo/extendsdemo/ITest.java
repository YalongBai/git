package com.gitdemos.testdemo.extendsdemo;

public abstract class ITest {

    /**
     *  描述：作为测试的公共类执行
     *  1、初始化模块：将类中的数据初始赋值 参数:intAttr1, intAttr2, intAttr3, strAttr1, strAttr2, strAttr3
     *  2、执行模块：执行需要操作的方法
     *  3、结果处理模块：将需要处理的结果处理
     *
     * */
    private int intAttr1;
    private int intAttr2;
    private int intAttr3;
    private String strAttr1;
    private String strAttr2;
    private String strAttr3;

    /**
     * 构造函数，初始化数据
     * */
    ITest(int intAttr1, int intAttr2, int intAttr3, String strAttr1, String strAttr2, String strAttr3){
        this.intAttr1 = intAttr1;
        this.intAttr2 = intAttr2;
        this.intAttr3 = intAttr3;
        this.strAttr1 = strAttr1;
        this.strAttr2 = strAttr2;
        this.strAttr3 = strAttr3;
    }

    /**
     *  事件初始化处理 （抽象）
     * */
    abstract void init();

    /**
     * 处理过程方法(抽象)
     * */
    abstract void handler();

    /**
     * 结果处理
     * */
    void doResult(){
        System.out.println("result :");
        System.out.println("intAttr1 = " + this.intAttr1 + ";\n intAttr2 = " + this.intAttr2 + ";\n intAttr3 = " + this.intAttr3);
        System.out.println("strAttr1 = " + this.strAttr1 + ";\n strAttr2 = " + this.strAttr2 + ";\n strAttr3 = " + this.strAttr3);
    }


}
