package ac.su.springmvcinclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ForwardRedirectController {
    @GetMapping("/ex-forward-from")
    //1번째 엔드포인트로 수신한 요청이 처리되기 위해서 다른 핸들러가 필요한 경우
    public String forwardFrom() {
        return "forward:/ex-forward-to"; //다른 핸들러로 보내줌
    }
    @GetMapping("/ex-forward-to")
    @ResponseBody
    public String forwardTo() {
        return "forwarded to /ex-forward-to";
        //Client 입장에서 1개의 요청에 대해 1개의 결과
    }

    @GetMapping("/ex-redirect-from")
    public String redirectFrom() {
        return "redirect:/ex-redirect-to";
        //redirect 클라이언트 협조가 반드시 필요
        //redirection 이 너무 많으면 -> 설계적으로 문제, 서비스 전달 불리
    }
    @GetMapping("/ex-redirect-to")
    @ResponseBody
    public String redirectTo() {
        return "redirected to /ex-redirect-to";
    }
}
