package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 张强 on 2016/8/9.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test() {
        return "hello/hello";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
