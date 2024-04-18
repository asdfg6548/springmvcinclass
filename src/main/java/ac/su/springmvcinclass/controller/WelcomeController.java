package ac.su.springmvcinclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class WelcomeController {
    @GetMapping("/")
    public String Welcome() {
        // GET 요청 처리 로직
        return "index";
    }

    //ModelAndView 방식

    @GetMapping("/ex-return-mv")
    public ModelAndView example() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("example-view");
        modelAndView.addObject("name", "John");
        modelAndView.addObject("age", 30);
        return modelAndView;
    }
    //Model to View 방식
    @GetMapping("/ex-return-m")
    public String example(Model model) {
        model.addAttribute("name", "John");
        model.addAttribute("age", 30);
        return "example-view";
    }
}
