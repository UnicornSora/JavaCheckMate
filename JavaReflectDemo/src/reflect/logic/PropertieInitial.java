package reflect.logic;

import java.io.*;
import java.util.Properties;

/**
 * Created by 张强 on 2016/10/21.
 */
public class PropertieInitial {
    public static Properties getPro() throws IOException {
        Properties pro = new Properties();
        File f = new File("fruit.properties");
        if (f.exists()) {
            pro.load(new FileInputStream(f));
        } else {
            pro.setProperty("apple", "reflect.bean.Apple");
            pro.setProperty("orange", "reflect.bean.Orange");
            pro.store(new FileOutputStream(f), "FRUIT CLASS");
        }
        return pro;
    }
}
