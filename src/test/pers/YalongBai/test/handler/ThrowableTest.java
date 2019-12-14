package test.pers.YalongBai.test.handler;

import test.pers.YalongBai.test.utils.TestFathor;
import test.pers.YalongBai.test.vo.DownZeroExcepion;

import java.util.Scanner;

/**
 *  java异常处理测试类
 */
public class ThrowableTest extends TestFathor {
    @Override
    protected void init() {


    }

    @Override
    public void handler() {
        CheckNum checkNum = new CheckNum();
        logger.info("测试check(int num):");
        Scanner scanner = new Scanner(System.in);
        try {
            do{
                logger.info("请输入数据:");
                checkNum.check(scanner.next());
                logger.info("Y/N?");
            }while (!scanner.next().equals("N"));
        } catch (DownZeroExcepion e) {
            e.printStackTrace();
        } finally {
            logger.info("测试完毕!");
        }
    }


    /**
     * 异常测试类
     * vo包中已定义一个抛出异常类，在此类中的check（Int num）、check(String str) 中添加异常测试
     *
     */
    class CheckNum {

        /**
         * 如果输入数据为null或者为空字符串时 则抛出错误
         * @param obj
         */
        protected void check(Object obj) throws DownZeroExcepion {

            System.out.println(obj);
            if(obj instanceof Double){

                System.out.println("这是浮点型值");
                if( (int)obj < 0) {
                    throw new DownZeroExcepion("数据格式不正确，输入数据不能小于零！");
                }
            }
            if(obj instanceof String) {
                System.out.println("这是字符型");
                // 数据判断
                if(obj == null || !obj.toString().isEmpty()){
                    throw  new DownZeroExcepion("数据格式不正确，输入数据不能为空！");
                }

            }

        }
    }
}
