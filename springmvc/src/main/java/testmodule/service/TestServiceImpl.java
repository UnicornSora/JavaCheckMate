package testmodule.service;

import base.converter.ObjectConverter;
import base.service.impl.BaseServiceImpl;
import testmodule.bean.TestInputDto;
import testmodule.bean.TestOutputDto;
import testmodule.converter.TestConverter;

/**
 * Created by eszha on 2017/1/10.
 */
public class TestServiceImpl extends BaseServiceImpl<TestInputDto, TestOutputDto> {

    @Override
    public void checkBefore(TestInputDto inputDto) throws Exception {
        if (inputDto == null) {
            throw new Exception("入力值inputDto为空");
        }
    }

    @Override
    public TestOutputDto doBusiness(TestInputDto inputDto) throws Exception {
        TestConverter testConverter = new TestConverter();
        return testConverter.source2Target(inputDto);
    }

    @Override
    public void checkAfter(TestOutputDto outputDto) throws Exception {
        if (outputDto == null) {
            throw new Exception("出力值outputDto为空");
        }
    }
}
