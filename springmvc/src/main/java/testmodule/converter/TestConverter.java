package testmodule.converter;

import base.converter.ObjectConverter;
import testmodule.bean.TestInputDto;
import testmodule.bean.TestOutputDto;

/**
 * Created by eszha on 2017/1/10.
 */
public class TestConverter implements ObjectConverter<TestInputDto, TestOutputDto> {

    @Override
    public TestOutputDto source2Target(TestInputDto source) {
        TestOutputDto target = new TestOutputDto();
        target.setId(source.getId());
        target.setValue(source.getValue());
        target.setOutputValue(source.getInputValue());
        return target;
    }

    @Override
    public TestInputDto target2Source(TestOutputDto target) {
        TestInputDto source = new TestInputDto();
        source.setId(target.getId());
        source.setValue(target.getValue());
        source.setInputValue(target.getOutputValue());
        return source;
    }
}
