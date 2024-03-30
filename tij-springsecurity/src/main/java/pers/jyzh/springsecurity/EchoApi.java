package pers.jyzh.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoApi {

    @GetMapping("/echo")
    public String echo(@RequestParam(value = "input", required = false) String input) {
        // 需要认证
        return input;
    }

    @GetMapping("/echoNoAuth")
    public String echoNoAuth(@RequestParam(value = "input", required = false) String input) {
        // 无需认证
        return input;
    }
}
