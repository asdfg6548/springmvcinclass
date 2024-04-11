package ac.su.springmvcinclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example")
public class WelcomeController {
    @GetMapping("/")
    public String Welcome() {
        // GET 요청 처리 로직
        return "index";
    }
}
