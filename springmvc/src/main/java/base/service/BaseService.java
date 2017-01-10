package base.service;

/**
 * Created by eszha on 2017/1/10.
 */
public interface BaseService<I, O> {

    O invoke(I inputDto) throws Exception;
}
