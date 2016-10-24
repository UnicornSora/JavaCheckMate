package reflect.bean;

/**
 * Created by 张强 on 2016/9/26.
 */
public class ReflectBean {

    private int reflect01;

    private String reflect02;

    public ReflectBean() {
    }

    public ReflectBean(int reflect01) {
        this.reflect01 = reflect01;
    }

    public ReflectBean(String reflect02) {
        this.reflect02 = reflect02;
    }

    public ReflectBean(int reflect01, String reflect02) {
        this.reflect01 = reflect01;
        this.reflect02 = reflect02;
    }

    @Override
    public String toString() {
        return "ReflectBean{" +
                "reflect01=" + reflect01 +
                ", reflect02='" + reflect02 + '\'' +
                '}';
    }

    public String showmethemoney(String arg01, int arg02) {
        String result = "kong";
        if (arg02 == 1) {
            result = arg01;
        }
        return result;
    }

    public int getReflect01() {
        return reflect01;
    }

    public void setReflect01(int reflect01) {
        this.reflect01 = reflect01;
    }

    public String getReflect02() {
        return reflect02;
    }

    public void setReflect02(String reflect02) {
        this.reflect02 = reflect02;
    }

}
