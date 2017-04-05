package reflect.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eszha on 2017/3/20.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

//        for (String s : list) {
//            if ("2".equals(s)) {
//                list.remove(s);
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("2".equals(s)) {
                list.remove(s);
            }
        }

        list.forEach(s -> System.out.println(s));
    }
}
