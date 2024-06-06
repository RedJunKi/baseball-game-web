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
    public String addForm(@ModelAttribute("member") Member member) {
        return "members/addMemberForm.html";
    }

    @PostMapping("/add")
    public String createMember(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "members/addMemberForm.html";
        }

        memberService.join(member);
        return "redirect:/";
    }

//
//    @PostMapping
//    public ResponseEntity<String> login(@RequestBody Map<String, String> requestBody) {
//
//        System.out.println("요청됨");
//
//        String id = requestBody.get("username");
//        String password = requestBody.get("password");
//
//        try {
//            memberService.login(id, password);
//            return ResponseEntity.ok("로그인 되었습니다.");
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//
//        }
//    }
}
