package test.pers.YalongBai.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:ss:mm");

    public static Logger getInstance(){
        return LoggerHolder.LOGGER;
    }

    private static class LoggerHolder{
        private static final Logger LOGGER = new Logger();
    }

    public void info(Object ob){
        if(ob == null) {
            outInfo(1, ()-> {
                Date date = new Date(System.currentTimeMillis());
                System.out.println(sdf.format(date) + ":" + ob);
            });
        } else {
            outInfo(1, ()-> {
                Date date = new Date(System.currentTimeMillis());
                System.out.println(sdf.format(date) + "  info : " + ob.toString());
            });
        }
    }

    private void outInfo(int level, LambdaInterface lambdaInterface){
        lambdaInterface.doLambda();
    }

}
