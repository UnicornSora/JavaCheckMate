package reflect.logic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 张强 on 2016/10/20.
 */
public class MockInvocationHandler implements InvocationHandler {

    private Object object = new Object();

    public Object bind(Object object) {
        System.out.println("before this.object = object" + object.getClass().getName());
        this.object = object;
        System.out.println("after this.object = object" + object.getClass().getName());
        System.out.println("before newProxyInstance");
        Object returnOb = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
        System.out.println("after newProxyInstance" + returnOb.getClass().getName());
        return returnOb;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke" + " proxy:" + proxy.getClass().getName() + " method:" + method.getClass().getName() + " args:" + args.getClass().getName());
        Object object = method.invoke(this.object, args);
        System.out.println("after invoke" + object.getClass().getName());
        return object;
    }
}
