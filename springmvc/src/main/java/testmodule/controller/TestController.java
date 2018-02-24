package testmodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    @ResponseBody
    @RequestMapping(value = "/transfor", method = RequestMethod.GET)
    public String transfor(@RequestParam(value = "num") String num) {
        return num;
    }
}
