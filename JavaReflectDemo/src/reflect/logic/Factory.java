package reflect.logic;

import reflect.bean.Apple;
import reflect.bean.Orange;
import reflect.interf.Fruit;

/**
 * Created by 张强 on 2016/10/21.
 */
public class Factory {
    public static Fruit getInstance(String fruitName) {
        Fruit f = null;
        if ("Apple".equals(fruitName)) {
            f = new Apple();
        }
        if ("Orange".equals(fruitName)) {
            f = new Orange();
        }
        return f;
    }

    public static Fruit getInstanceReflect(String ClassName) {
        Fruit f = null;
        try {
            f = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
