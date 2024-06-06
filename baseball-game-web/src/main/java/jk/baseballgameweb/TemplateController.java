package jk.baseballgameweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @GetMapping("/fragment")
    public String template() {
        return "fragment/fragmentMain";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/members/addMemberForm")
    public String addMemberForm() {
        return "members/addMemberForm";
    }
}
