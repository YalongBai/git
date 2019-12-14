package test.pers.YalongBai.test.vo;

public class DownZeroExcepion extends Exception{
    public DownZeroExcepion() {
    }

    public DownZeroExcepion(String message) {
        super(message);
    }

    public DownZeroExcepion(String message, Throwable cause) {
        super(message, cause);
    }

    public DownZeroExcepion(Throwable cause) {
        super(cause);
    }

    public DownZeroExcepion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
