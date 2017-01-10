package base.converter;

/**
 * Created by eszha on 2017/1/10.
 */
public interface ObjectConverter<S, T> {

    public T source2Target(S source);

    public S target2Source(T target);
}
