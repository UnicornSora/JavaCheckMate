package service;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by 张强 on 2016/9/12.
 */
public interface BaseServiceFactory<T, S> {

    default S execute(T t) {
        Predicate<String> b = String::isEmpty;
        return null;
    }


}
