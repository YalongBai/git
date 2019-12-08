package test.pers.YalongBai.test.handler;

/**
 * @author 白亚龙
 * 常见6中单例模式创建方式
 *
 * */
public class SingleTonTest {

    /**
     * 1、饿汉式-静态常量方式（线程安全）
     * 类加载时就初始化了类，避免了多线程同步问题。天然线程安全
     */
    static class SingleTon extends SingleTonTest{
        // 静态单例
        private static SingleTon singleTon = new SingleTon();
        private SingleTon() {
        }

        public static SingleTon getInstance(){
            return SingleTon.singleTon;
        }
    }

    /**
     * 2、饿汉式-静态代码块式（线程安全）
     * 将静态常量放入静态块实例化
     * */
    static class SingleTon1{
        // 静态实例
        private static SingleTon1 instance;
        /**
         * 静态代码块
         * */
        static {
            instance = new SingleTon1();
        }

        public SingleTon1() {
        }
        // 获取实例
        public static SingleTon1 getInstance(){
            return instance;
        }
    }

    /**
     * 3、懒汉式 （线程不安全）
     *  这是最基本的实现方式，第一次调用初始化实现了懒加载的特性。多线程场景下禁止使用，因为可能会产生多个对象，不再是单例。
     * */
    static class SingleTon2 {

        private static SingleTon2 instance;
        // 获取实例
        public static SingleTon2 getInstance(){
                if(instance == null){
                    instance = new SingleTon2();
                }
                return instance;
        }

        public SingleTon2() {
        }
    }

    /**
     * 4、懒汉式 方法上加同步锁
     * 获取实例的方法上加了同步锁，保证了多线程下的单例
     * */
    static class SingleTon3 {
        // 静态实例对象
        private static SingleTon3 instance;

        // 构造函数
        public SingleTon3() {
        }

        // 获取实例
        public static synchronized SingleTon3 getInstance(){
            if(instance == null){
                instance = new SingleTon3();
            }
            return instance;
        }
    }

    /**
     *5、双重校验锁（线程安全，效率高）
     *
     * 这种实现不需要每次都要获得锁，减少了获取锁和等待的时间
     * 注意volatile关键字的使用， 保证了个线程对instance静态实例的修改的可见性
     *
     * */
    static class SingleTon4 {
        // 单例实体  volatile 可见性实现
        private static volatile SingleTon4 instance;

        public SingleTon4() {
        }

        // 获取实例
        public static SingleTon4 getInstance(){
            if(instance == null ){
                synchronized (SingleTon4.class){
                    instance = new SingleTon4();
                }
            }
            return instance;
        }
    }

    /**
     * 6、 静态内部类实现单例（线程安全、效率高）
     * 这种方式SingleTon 类被装载了，instance也不一定会初始化，因为SingleTonHolder没有被主动调用,只有显示调用getInstance方法时，
     * 才会显示转载SingleTonHolder类，从而实例化instance。
     * 注意内部类SingleTonHolder需要用static 且其中静态变量INSTANCE必须是final
     * */
    private static class SingleTon5 {
        public static SingleTon5 getInstance(){
            return SingleTon5Holder.INSTANCE;
        }

        private SingleTon5() {
        }

        // 获取实例
        private static final class SingleTon5Holder{
            private static  final  SingleTon5 INSTANCE = new SingleTon5();
        }
    }

    public static Object  getInstance(String classType){
        if("SingleTon".equals(classType)){
            return SingleTon.getInstance();
        } else if("SingleTon1".equals(classType)){
            return SingleTon1.getInstance();
        } else if("SingleTon2".equals(classType)){
            return SingleTon2.getInstance();
        } else if("SingleTon3".equals(classType)){
            return SingleTon3.getInstance();
        } else if("SingleTon4".equals(classType)){
            return SingleTon4.getInstance();
        } else if("SingleTon5".equals(classType)){
            return SingleTon5.getInstance();
        }else {
            return null;
        }
    }

}
