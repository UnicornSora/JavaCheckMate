package reflect.logic;

import com.sun.org.apache.xml.internal.security.Init;
import reflect.bean.ReflectBean;
import reflect.bean.ReflectInterfaceImpl;
import reflect.interf.Fruit;
import reflect.interf.ReflectInterface;

import javax.naming.NameNotFoundException;
import java.awt.*;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * java 反射机制的一些实例讲解
 * Created by 张强 on 2016/9/26.
 */
public class ReflectLogic {

    /**
     * 通过一个对象获得完整的包名和类名
     */
    public void function01() {
        ReflectBean reflectBean = new ReflectBean();
        System.out.println(reflectBean.getClass().getName());
    }

    /**
     * 实例化Class类对象
     *
     * @param className
     */
    public void funciton02(String className) {
        Class<?> demo1 = null;
        Class<?> demo2 = null;
        Class<?> demo3 = null;

        try {
            demo1 = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        demo2 = new ReflectBean().getClass();
        demo3 = ReflectBean.class;

        System.out.println("demo1:" + demo1.getName());
        System.out.println("demo2:" + demo2.getName());
        System.out.println("demo3:" + demo3.getName());

    }

    /**
     * 通过Class实例化其他类的对象
     *
     * @param className
     */
    public void funciton03(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ReflectBean reflectBean = null;
        try {
            reflectBean = (ReflectBean) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        reflectBean.setReflect01(1);
        reflectBean.setReflect02("2");
        System.out.println(reflectBean);
    }

    /**
     * 通过Class调用其他类中的构造函数 （也可以通过这种方式通过Class创建其他类的对象）
     *
     * @param className
     */
    public void function04(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ReflectBean reflectBean1 = null;
        ReflectBean reflectBean2 = null;
        ReflectBean reflectBean3 = null;
        ReflectBean reflectBean4 = null;

        Constructor<?> constructor[] = demo.getConstructors();

        try {
            reflectBean1 = (ReflectBean) constructor[3].newInstance();
            reflectBean3 = (ReflectBean) constructor[2].newInstance(1);
            reflectBean2 = (ReflectBean) constructor[1].newInstance("2");
            reflectBean4 = (ReflectBean) constructor[0].newInstance(1, "2");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(reflectBean1);
        System.out.println(reflectBean2);
        System.out.println(reflectBean3);
        System.out.println(reflectBean4);
    }

    /**
     * 返回一个类实现的接口
     *
     * @param className
     */
    public void function05(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> demoInterfaces[] = demo.getInterfaces();
        for (int i = 0; i < demoInterfaces.length; i++) {
            System.out.println("interface:" + demoInterfaces[i].getName());
        }
    }

    /**
     * 取得其他类中的父类
     *
     * @param className
     */
    public void function06(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> son = demo.getSuperclass();
        System.out.println("father:" + son.getName());
    }

    /**
     * 获得其他类中的全部构造函数
     *
     * @param className
     */
    public void function07(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> demoInterfaces[] = demo.getConstructors();
        for (int i = 0; i < demoInterfaces.length; i++) {
            System.out.println("Constructor:" + demoInterfaces[i]);
        }
    }

    /**
     * 获取修饰符
     *
     * @param className
     */
    public void function08(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> demoInterfaces[] = demo.getConstructors();
        for (int i = 0; i < demoInterfaces.length; i++) {
            Class<?> p[] = demoInterfaces[i].getParameterTypes();
            System.out.print("构造方法：  ");
            int mo = demoInterfaces[i].getModifiers();
            System.out.print(Modifier.toString(mo) + " ");
            System.out.print(demoInterfaces[i].getName());
            System.out.print("(");
            for (int j = 0; j < p.length; ++j) {
                System.out.print(p[j].getName() + " arg" + i);
                if (j < p.length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("){}");
        }
    }

    /**
     * 获取修饰符,包括异常
     *
     * @param className
     */
    public void function09(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Method method[] = demo.getMethods();
        for (int i = 0; i < method.length; ++i) {
            Class<?> returnType = method[i].getReturnType();
            Class<?> para[] = method[i].getParameterTypes();
            int temp = method[i].getModifiers();
            System.out.print(Modifier.toString(temp) + " ");
            System.out.print(returnType.getName() + "  ");
            System.out.print(method[i].getName() + " ");
            System.out.print("(");
            for (int j = 0; j < para.length; ++j) {
                System.out.print(para[j].getName() + " " + "arg" + j);
                if (j < para.length - 1) {
                    System.out.print(",");
                }
            }
            Class<?> exce[] = method[i].getExceptionTypes();
            if (exce.length > 0) {
                System.out.print(") throws ");
                for (int k = 0; k < exce.length; ++k) {
                    System.out.print(exce[k].getName() + " ");
                    if (k < exce.length - 1) {
                        System.out.print(",");
                    }
                }
            } else {
                System.out.print(")");
            }
            System.out.println();
        }
    }

    /**
     * 接下来让我们取得其他类的全部属性吧，最后我讲这些整理在一起，也就是通过class取得一个类的全部框架
     *
     * @param className
     */
    public void function10(String className) {
        Class<?> demo = null;
        try {
            demo = Class.forName(className);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("===============本类属性========================");
        // 取得本类的全部属性
        Field[] field = demo.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            // 权限修饰符
            int mo = field[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = field[i].getType();
            System.out.println(priv + " " + type.getName() + " " + field[i].getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        // 取得实现的接口或者父类的属性
        Field[] filed1 = demo.getFields();
        for (int j = 0; j < filed1.length; j++) {
            // 权限修饰符
            int mo = filed1[j].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = filed1[j].getType();
            System.out.println(priv + " " + type.getName() + " " + filed1[j].getName() + ";");
        }
    }

    /**
     * 其实还可以通过反射调用其他类中的方法
     *
     * @param classname
     */
    public void function11(String classname) {
        Class<?> demo = null;
        try {
            demo = Class.forName(classname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Method[] methods = demo.getMethods();
//            for (Method method : methods) {
//                System.out.println(method.getName());
//            }
            Method method = demo.getMethod("showmethemoney", String.class, int.class);
            System.out.println(method.invoke(demo.newInstance(), "3232", 1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 调用其他类的set和get方法
     *
     * @param classname
     */
    public void function12(String classname) {
        Class<?> demo = null;
        Object obj = null;
        try {
            demo = Class.forName(classname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            obj = demo.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setter(obj, "Reflect01", 12, int.class);
        getter(obj, "Reflect01");

    }

    /**
     *      * @param obj
     *      *            操作的对象
     *      * @param att
     *      *            操作的属性
     *      *
     */
    public static void getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + att);
            System.out.println(method.invoke(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *      * @param obj
     *      *            操作的对象
     *      * @param att
     *      *            操作的属性
     *      * @param value
     *      *            设置的值
     *      * @param type
     *      *            参数的属性
     *      *
     */
    public static void setter(Object obj, String att, Object value,
                              Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + att, type);
            method.invoke(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射操作属性
     *
     * @param className
     */
    public void funciton13(String className) {
        Class<?> demo = null;
        Object object = null;
        try {
            demo = Class.forName(className);
            object = demo.newInstance();

            Field field = demo.getDeclaredField("reflect01");
            field.setAccessible(true);
            field.set(object, 13);
            System.out.println(field.get(object));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过反射取得并修改数组的信息
     */
    public void function14() {
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }

    /**
     * 通过反射修改数组大小
     */
    public void function15() {
        int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] newTemp = (int[]) arrayInc(temp, 15);
        print(newTemp);
        System.out.println("=====================");
        String[] atr = {"a", "b", "c"};
        String[] str1 = (String[]) arrayInc(atr, 8);
        print(str1);
    }

    /**
     * 修改数组大小
     */
    public static Object arrayInc(Object obj, int len) {
        Class<?> arr = obj.getClass().getComponentType();
        Object newArr = Array.newInstance(arr, len);
        int co = Array.getLength(obj);
        System.arraycopy(obj, 0, newArr, 0, co);
        return newArr;
    }

    /**
     * 打印
     */
    public static void print(Object obj) {
        Class<?> c = obj.getClass();
        if (!c.isArray()) {
            return;
        }
        System.out.println("数组长度为： " + Array.getLength(obj));
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.print(Array.get(obj, i) + " ");
        }
    }

    /**
     * getComponentType相关
     */
    public void function1501() {
        try {
            String[] strings = {"a", "b", "c"};
            Class demoClass = strings.getClass();
            System.out.println(demoClass);
            System.out.println(demoClass.getName());
            Class demoClassComponentType = demoClass.getComponentType();
            System.out.println(demoClassComponentType);
            System.out.println(demoClassComponentType.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 如何获得类加载器
     * 在java中有三种类类加载器。
     * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
     * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器。
     *
     * @param className
     */
    public void function16(String className) {
        try {
            Object object = Class.forName(className).newInstance();
            System.out.println(object.getClass().getClassLoader().getClass().getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 动态代理
     */
    public void function17() {
        try {
            MockInvocationHandler mockInvocationHandler = new MockInvocationHandler();
            System.out.println("mockInvocationHandler:" + mockInvocationHandler.getClass().getName());
            ReflectInterface reflectInterface = (ReflectInterface) mockInvocationHandler.bind(new ReflectInterfaceImpl());
            System.out.println("before sayNo,reflectInterface:" + reflectInterface.getClass().getName());
            reflectInterface.sayNO("名字", 2);
            System.out.println("after sayNo,reflectInterface:" + reflectInterface.getClass().getName());
        } catch (Exception e) {

        }
    }

    /**
     * 类的生命周期
     * 在一个类编译完成之后，下一步就需要开始使用类，如果要使用一个类，肯定离不开JVM。在程序执行中JVM通过装载，链接，初始化这3个步骤完成。
     * 类的装载是通过类加载器完成的，加载器将.class文件的二进制文件装入JVM的方法区，并且在堆区创建描述这个类的java.lang.Class对象。用来封装数据。 但是同一个类只会被类装载器装载以前
     * 链接就是把二进制数据组装为可以运行的状态。
     *  
     * 链接分为校验，准备，解析这3个阶段
     * 校验一般用来确认此二进制文件是否适合当前的JVM（版本），
     * 准备就是为静态成员分配内存空间，。并设置默认值
     * 解析指的是转换常量池中的代码作为直接引用的过程，直到所有的符号引用都可以被运行程序使用（建立完整的对应关系）
     * 完成之后，类型也就完成了初始化，初始化之后类的对象就可以正常使用了，直到一个对象不再使用之后，将被垃圾回收。释放空间。
     * 当没有任何引用指向Class对象时就会被卸载，结束类的生命周期
     * <p>
     * 设计模式之 工厂模式
     */
    public void function18(String className) {
        Fruit fruit = Factory.getInstance(className);
        fruit.eat();
    }

    /**
     * 设计模式之 工厂模式 反射版本
     *
     * @param className
     */
    public void function19(String className) {
        Fruit fruit = Factory.getInstanceReflect(className);
        fruit.eat();
    }

    /**
     * 设计模式之 工厂模式 反射版本读取配置文件
     *
     * @param className
     */
    public void function20(String className) {
        try {
            Properties properties = PropertieInitial.getPro();
            Fruit fruit = Factory.getInstanceReflect(properties.getProperty(className));
            fruit.eat();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String className = "reflect.bean.ReflectBean";
        String classNameInterface = "reflect.bean.ReflectInterfaceImpl";
        String classNameSon = "reflect.bean.ReflectSonBean";
        ReflectLogic reflectLogic = new ReflectLogic();
//        reflectLogic.function01();
//        reflectLogic.funciton02(className);
//        reflectLogic.funciton03(className);
//        reflectLogic.function04(className);
//        reflectLogic.function05(classNameInterface);
//        reflectLogic.function06(classNameSon);
//        reflectLogic.function07(className);
//        reflectLogic.function08(className);
//        reflectLogic.function09(className);
//        reflectLogic.function10(classNameInterface);
//        reflectLogic.function11(className);
//        reflectLogic.function12(className);
//        reflectLogic.funciton13(className);
//        reflectLogic.function14();
//        reflectLogic.function15();
//        reflectLogic.function1501();
//        reflectLogic.function16(className);
//        reflectLogic.function17();
//        reflectLogic.function18("Orange");
//        reflectLogic.function19("reflect.bean.Apple");
        reflectLogic.function20("apple");
    }
}
