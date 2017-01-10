package testmodule.bean;

import base.bean.dto.OutputDto;

/**
 * Created by eszha on 2017/1/10.
 */
public class TestOutputDto extends OutputDto {

    private String outputValue;

    @Override
    public String toString() {
        return "TestOutputDto{" +
                "outputValue='" + outputValue + '\'' +
                "} " + super.toString();
    }

    public String getOutputValue() {
        return outputValue;
    }

    public void setOutputValue(String outputValue) {
        this.outputValue = outputValue;
    }
}
