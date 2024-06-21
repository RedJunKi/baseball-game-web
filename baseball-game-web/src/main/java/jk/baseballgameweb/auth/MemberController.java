package jk.baseballgameweb.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("memberDto") MemberDto memberDto) {
        return "members/addMemberForm.html";
    }

    @PostMapping("/add")
    public String createMember(@Validated @ModelAttribute MemberDto memberDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm.html";
        }
        try {
            memberService.join(memberDto);
        } catch (IllegalStateException e) {
            return "error/duplicate-member";
        }
        return "redirect:/login";
    }
}
