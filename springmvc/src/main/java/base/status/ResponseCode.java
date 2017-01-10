package base.status;

/**
 * Created by eszha on 2017/1/10.
 */
public enum ResponseCode {

    SUCCESS(0L, "SUCCESS", "成功"),
    FAIL(1L, "FAIL", "失败");

    long value;
    String name;
    String message;

    ResponseCode(long value, String name, String message) {
        this.value = value;
        this.name = name;
        this.message = message;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
