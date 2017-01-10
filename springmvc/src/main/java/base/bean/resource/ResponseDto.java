package base.bean.resource;

/**
 * Created by eszha on 2017/1/10.
 */
public class ResponseDto {

    long resCode;
    String resMessage;
    Object resData;

    @Override
    public String toString() {
        return "ResponseDto{" +
                "resCode=" + resCode +
                ", resMessage='" + resMessage + '\'' +
                ", resData=" + resData +
                '}';
    }

    public long getResCode() {
        return resCode;
    }

    public void setResCode(long resCode) {
        this.resCode = resCode;
    }

    public String getResMessage() {
        return resMessage;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public Object getResData() {
        return resData;
    }

    public void setResData(Object resData) {
        this.resData = resData;
    }
}
