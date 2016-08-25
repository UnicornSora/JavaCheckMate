import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 张强 on 2016/8/8.
 */
public class Lambda {
    public static void main(String[] args) {
        String a = "sdwae啊啊啊啊啊a$#%$$@$#$#$#啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊";
        String b = "12345";
        System.out.println(bSubstring(a, 60));
        System.out.println(bSubstring(b, 60));


        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("3");
        Collections.sort(list, (x, y) -> x.compareTo(y));
        list.forEach(o -> System.out.println(o));
    }

    /**
     * @param s
     * @param length
     * @return String
     * @Title: bSubstring
     * @Description: 根据特定长度截取字符串 （可以截取中文）
     */
    public static String bSubstring(String s, int length) {
        try {
            byte[] bytes = s.getBytes("Unicode");
            int n = 0; // 表示当前的字节数
            int i = 2; // 要截取的字节数 ，从第3个字节开始
            for (; i < bytes.length && n < length; i++) {
                // 奇数位置，如3、5、7等，为UCS2编码中两个字节的第二个字节
                if (i % 2 == 1) {
                    n++; // 在UCS2第二个字节时n加1
                } else {
                    // 当UCS2编码的第一个字节不等于0时，该UCS2字符为汉字，一个汉字算两个字节
                    if (bytes[i] != 0) {
                        n++;
                    }
                }
            }
            // 如果i为奇数时，处理成偶数
            if (i % 2 == 1) {
                // 该UCS2字符是汉字时，去掉这个截一半的汉字
                if (bytes[i - 1] != 0)
                    i = i - 1;
                    // 该UCS2字符是字母或数字，则保留该字符
                else
                    i = i + 1;
            }
            return new String(bytes, 0, i, "Unicode");
        } catch (Exception e) {
            return "";
        }
    }
}
