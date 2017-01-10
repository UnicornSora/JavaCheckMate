import base.bean.resource.ResponseDto;
import base.status.ResponseCode;
import testmodule.bean.TestInputDto;
import testmodule.resource.TestResource;

/**
 * Created by eszha on 2017/1/10.
 */
public class UnitTest {

    public static void main(String[] args) {
        TestResource testResource = new TestResource();
        TestInputDto testInputDto = new TestInputDto();
        testInputDto.setId(1);
        ResponseDto responseDto = testResource.testresourcefunction(testInputDto);
        System.out.println(responseDto.getResCode());
        System.out.println(responseDto.getResMessage());
        if (responseDto.getResCode() == ResponseCode.SUCCESS.getValue()) {
            System.out.println(responseDto.getResData().toString());
        }
    }
}
