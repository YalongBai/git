package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.Logger;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

     /**
    * @Description: 继承ReentrantLock 测试公平锁与非公平锁
    * @Param: 
    * @Return: 
    * @Auther: 白亚龙
    * @Date: 2020/1/1
    */
public class LockTest extends ReentrantLock {
    Logger logger = Logger.getInstance();
    /**
    * @Description:   公平锁与非公平锁测试(公平锁就是保障了多线程下各线程获取锁的顺序，先到的线程优先获取锁，而非公平锁则无法提供这个保障)
    * @Param:
    * @Return:
    * @Auther: 白亚龙
    * @Date: 2020/1/1
    */
    public void reentrantLockTest() {
        try {
            logger.info( "公平锁测试");
            testTryAcquire(true, 4);
            /*
            Scanner scanner = new Scanner(System.in);
            logger.info("非公平锁测试");
            testTryAcquire(false, 4);*/
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    // （非）公平锁测试
    private void testTryAcquire(boolean flag, int cycle) throws Exception{
        LockDemo lockDemo = new LockDemo();

        //
        for (int i = 0; i < cycle; i++) {
            new Thread(()->{
                try {
                lockDemo.getLock();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread" + i).start();
        }
        // 确保上边程序执行完成
        Thread.sleep(1000);
        Scanner scanner = new Scanner(System.in);
        logger.info("点击任意键唤醒线程...");
        scanner.nextLine();

        for (int i = 0; i < cycle; i++) {
            new Thread( ()->{
                lockDemo.relaseLock();
            } ).start();
        }


    }

    private class LockDemo {
        ReentrantLock lock  = new ReentrantLock();
        /*public LockDemo(){
            lock = new ReentrantLock();
        }*/

        /*public LockDemo(boolean flag){
            lock = new ReentrantLock(flag);
        }*/

        Condition condition = lock == null ? new ReentrantLock().newCondition() : lock.newCondition();

        // 唤醒线程
        protected void getLock() throws InterruptedException {
            logger.info(Thread.currentThread().getName() + ",  ready to lock ===");
            lock.lock();
            logger.info(Thread.currentThread().getName() + ", condition ready to await!");
            condition.await();
            logger.info(Thread.currentThread().getName() + ", condition ready to unlock!");
            lock.unlock();
        }

        // 沉睡线程
        protected void relaseLock () {
            logger.info(Thread.currentThread().getName() + ",condition ready to lock ===");
            lock.lock();
            logger.info(Thread.currentThread().getName() + ", condition ready to await!");
            condition.signal();
            logger.info(Thread.currentThread().getName() + ", condition ready to unlock!");
            lock.unlock();
        }

    }
}
