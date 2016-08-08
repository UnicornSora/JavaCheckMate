import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 张强 on 2016/8/8.
 */
public class Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("3");
        Collections.sort(list, (x, y) -> x.compareTo(y));
        list.forEach(o -> System.out.println(o));
    }

}
