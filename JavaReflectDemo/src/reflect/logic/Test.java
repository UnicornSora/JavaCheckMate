package reflect.logic;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by eszha on 2017/3/20.
 */
public class Test {

    public static void main(String[] args) {
//        try {
//            byte[] gbk = "中文".getBytes("GBK");
//            byte[] utf8 = "中文".getBytes("utf8");
//            byte[] iso = "中文".getBytes("iso8859-1");
//
//            System.out.println(new String(gbk, "gbk"));
//            System.out.println(new String(gbk, "utf8"));
//            System.out.println(new String(gbk, "iso8859-1"));
//            System.out.println(new String(utf8, "gbk"));
//            System.out.println(new String(utf8, "utf8"));
//            System.out.println(new String(utf8, "iso8859-1"));
//            System.out.println(new String(iso, "gbk"));
//            System.out.println(new String(iso, "utf8"));
//            System.out.println(new String(iso, "iso8859-1"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GB2312
                String s = encode;
                return s;      //是的话，返回“GB2312“，以下代码同理
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是ISO-8859-1
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {   //判断是不是UTF-8
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {      //判断是不是GBK
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";        //如果都不是，说明输入的内容不属于常见的编码格式。
    }
}
