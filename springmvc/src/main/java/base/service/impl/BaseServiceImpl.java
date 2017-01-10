package base.service.impl;

import base.service.BaseService;

/**
 * Created by eszha on 2017/1/10.
 */
public abstract class BaseServiceImpl<I, O> implements BaseService<I, O> {

    @Override
    public O invoke(I inputDto) throws Exception {
        checkBefore(inputDto);
        O outputDto = doBusiness(inputDto);
        checkAfter(outputDto);
        return outputDto;
    }

    public abstract void checkBefore(I inputDto) throws Exception;

    public abstract O doBusiness(I inputDto) throws Exception;

    public abstract void checkAfter(O outputDto) throws Exception;

}
