package testmodule.bean;

import base.bean.dto.InputDto;

/**
 * Created by eszha on 2017/1/10.
 */
public class TestInputDto extends InputDto {

    private String inputValue;

    @Override
    public String toString() {
        return "TestInputDto{" +
                "inputValue='" + inputValue + '\'' +
                "} " + super.toString();
    }

    public String getInputValue() {
        return inputValue;
    }

    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
}
