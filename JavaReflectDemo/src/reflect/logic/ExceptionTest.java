package reflect.logic;

import reflect.bean.AppException;
import reflect.bean.ServiceException;

import java.util.Locale;

/**
 * Created by eszha on 2017/7/4.
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            ExceptionTest exceptionTest = new ExceptionTest();
            exceptionTest.test1();
//        } catch (ServiceException e) {
//            System.out.println(e);
//            System.out.println("ser");
        } catch (NullPointerException e) {
            System.out.println(e);
            System.out.println("null");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("ex");
        }
    }

    public void test1() {
        String a = null;
        System.out.println("test1a");
        a.equals(1);
        System.out.println("test1b");
    }

    public void test2() {
        System.out.println("test2a");
        test1();
        System.out.println("test2b");
    }

    public void test3() {
        System.out.println("test3a");
        test2();
        System.out.println("test3b");
    }
}