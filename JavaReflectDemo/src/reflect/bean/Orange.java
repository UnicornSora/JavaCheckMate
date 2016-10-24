package reflect.bean;

import reflect.interf.Fruit;

/**
 * Created by 张强 on 2016/10/21.
 */
public class Orange implements Fruit {
    @Override
    public void eat() {
        System.out.println(this.getClass().getName());
    }
}
