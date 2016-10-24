package reflect.bean;

import reflect.interf.ReflectInterface;

/**
 * Created by 张强 on 2016/9/26.
 */
public class ReflectInterfaceImpl implements ReflectInterface {

    private String sex;

    public ReflectInterfaceImpl() {
    }

    public ReflectInterfaceImpl(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public void sayYES() {
        System.out.println("hello ,china");
    }

    @Override
    public void sayNO(String name, int age) {
        System.out.println(name + "  " + age);
    }
}
