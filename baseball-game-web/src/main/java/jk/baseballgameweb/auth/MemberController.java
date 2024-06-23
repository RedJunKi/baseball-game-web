package jk.baseballgameweb.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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

    @PatchMapping("/update")
    public String updateMember(@ModelAttribute MemberDto memberDto) {
        memberService.updateMember(getMember().getId(), memberDto);
        return "redirect:/";
    }

    public MemberDto findLoginMemberInfo() {
        Member member = getMember();
        return new MemberDto(member.getUsername(), member.getName(), member.getPassword());
    }

    private Member getMember() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Optional<Member> result = memberService.findByUsername(name);
        if (result.isEmpty()) {
            throw new IllegalStateException("회원이 없습니다.");
        }
        return result.get();
    }

    public void delete() {
        memberService.delete(getMember());
    }
}
