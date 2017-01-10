package testmodule.resource;

import base.bean.resource.ResponseDto;
import base.service.BaseService;
import base.status.ResponseCode;
import testmodule.bean.TestInputDto;
import testmodule.bean.TestOutputDto;
import testmodule.service.TestServiceImpl;

/**
 * Created by eszha on 2017/1/10.
 */
public class TestResource {

    public ResponseDto testresourcefunction(TestInputDto testInputDto) {
        ResponseDto responseDto = new ResponseDto();
        try {
            BaseService<TestInputDto, TestOutputDto> testServiceImpl = new TestServiceImpl();
            TestOutputDto testOutputDto = testServiceImpl.invoke(testInputDto);
            responseDto.setResCode(ResponseCode.SUCCESS.getValue());
            responseDto.setResData(testOutputDto);
            responseDto.setResMessage(ResponseCode.SUCCESS.getMessage());
        } catch (Exception e) {
            responseDto.setResCode(ResponseCode.FAIL.getValue());
            responseDto.setResMessage(ResponseCode.FAIL.getMessage());
        }
        return responseDto;
    }
}
