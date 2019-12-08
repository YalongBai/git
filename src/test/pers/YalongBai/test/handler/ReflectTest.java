package test.pers.YalongBai.test.handler;


import test.pers.YalongBai.test.utils.TestFathor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 白亚龙
 * @des 反射测试类  getDeclaredXXX() 返回本类所有XXX （不包含父类）
 *                getXXX() 返回所有公用XXX （包含父类属性）
 *                使用时一般推荐使用第二种，因为第二种更具有实用性
 * @date 2019年11月29日07:33:43
 *
 */
public class ReflectTest extends TestFathor {

    private static Class<?> clazz;
    /**
     * 根据类名获取类实体
     * @param className
     * @return
     */
    private Class<?> initClassObj(String className){
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            logger.info("不存在的类");
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 获取所有构造方法
     * 1 getDeclaredConstructors() 方法获取所有构造方法（包括私有）
     * 2 getConstructors() 获取所有非私有构造方法
     *
     */
    private void showContructors(){
        Constructor[] constructors = clazz.getDeclaredConstructors();
        logger.info("所有构造方法：");
        for (Constructor constructor: constructors){
            logger.info(constructor);
        }
        Constructor[] constructors1 = clazz.getConstructors();
        logger.info("所有非私有构造方法：");
        for (Constructor constructor: constructors1){
            logger.info(constructor);
        }
    }

    /**
     * 获取所有变量
     * getDeclareeFields() 获取所有自身变量
     * getFields() 获取所有公共有变量
     */
    private void showFields(){
        logger.info("本类所有参数:");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            logger.info(field);
        }

        logger.info("所有共有有参数:");
        Field[] fields1 = clazz.getFields();
        for(Field field: fields1){
            logger.info(field);
        }
    }

    /**
     * 展示所有方法
     * getDeclaredMethods() 获取本类所有方法（非继承）
     * getMethods() 获取所有公有方法（包含超类）
     */
    private void showMethods(){
        logger.info("本类所有方法：");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods){
            logger.info(method);
        }
        logger.info("所有非私有方法");
        Method[] methods1 = clazz.getMethods();
        for (Method method: methods1){
            logger.info(method);
        }
    }


    /**
     * 初始化类
     */
    @Override
    public void init() {
        logger.info("展示AbstractTest的属性：");
        logger.info("1. 初始化类：");
        initClassObj("test.pers.YalongBai.test.handler.AbstractTest");

    }

    /**
     * 初始化类
     */
    public void init(String className) {
        logger.info("展示" + className + "的属性。");
        logger.info("1. 初始化类");
        initClassObj(className);

    }

    /**
     * 展示类数据
     */
    public void showClass(){
        logger.info("2. 展示所有构造方法：");
        showContructors();
        logger.info("3. 展示所有变量、常量：");
        showFields();
        logger.info("4. 展示所有方法：");
        showMethods();
    }

    /**
     * 改变AbstractTest中的属性
     * */
    private void operaField(String fieldName, String value){
        Field field = null;
        Object o = null;
        try {
            o = clazz.newInstance();
            logger.info("获取" + fieldName + "的参数");
            field = clazz.getDeclaredField(fieldName);
            logger.info("私有变量需要先获取权限!");
            field.setAccessible(true);  // 设置私有权限可以被访问修改
            String value1 = (String) field.get(o);
            logger.info("调用并执行test1方法");
            Method method = clazz.getMethod("test1");
            method.invoke(o);  // 参数
            logger.info("将至修改为"+ value);
            field.set(o, value);
            method.invoke(o);
        } catch (NoSuchFieldException e) {
            logger.info("未含有该类或者没有操作权限");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handler() {
        logger.info("操作AbstractTest类中的属性：");
        operaField("privateValue", "你好，世界！");

    }
}
