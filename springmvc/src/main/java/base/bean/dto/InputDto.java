package base.bean.dto;

/**
 * Created by eszha on 2017/1/10.
 */
public class InputDto {

    private int id;

    private String value;

    @Override
    public String toString() {
        return "InputDto{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
