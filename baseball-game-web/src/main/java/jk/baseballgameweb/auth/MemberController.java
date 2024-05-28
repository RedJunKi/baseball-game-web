package jk.baseballgameweb.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/create-member")
    public ResponseEntity<String> createMember(@Valid @RequestBody Member member) {
        System.out.println("member.getName() = " + member.getName());
        System.out.println("member.getPassword() = " + member.getPassword());
        System.out.println("요청됨");
        try {
            memberService.join(member);
            return ResponseEntity.ok("회원가입이 완료되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
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
