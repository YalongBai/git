package test.pers.YalongBai.test.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:ss:mm");

    private Logger() {
    }

    public static Logger getInstance(){
        return LoggerHolder.LOGGER;
    }


    private static class LoggerHolder{
        private static final Logger LOGGER = new Logger();
    }

    public void info(Object ob){
        Date date = new Date(System.currentTimeMillis());
        if(ob == null){
            System.out.println(sdf.format(date) + ":" + ob);
        }else{
            System.out.println(sdf.format(date) + "  info : " + ob.toString());
        }
    }

}
