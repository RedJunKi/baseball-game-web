package jk.baseballgameweb.homecontroller;

import jk.baseballgameweb.auth.Member;
import jk.baseballgameweb.auth.MemberController;
import jk.baseballgameweb.auth.MemberDto;
import jk.baseballgameweb.board.Board;
import jk.baseballgameweb.board.BoardController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardController boardController;
    private final MemberController memberController;

    @GetMapping
    public String home() {
        return "fragments/home";
    }

    @GetMapping("board")
    public String board(Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Board> boards = boardController.getBoards(page, size);

        model.addAttribute("posts", boards.getContent());
        model.addAttribute("page", boards);
        return "board/board-home";
    }

    @GetMapping("board/post")
    public String boardPostView() {
        return "board/post";
    }

    @PostMapping("board/post")
    public String boardPost(@RequestParam("title") String title,
                            @RequestParam("content") String content,
                            Model model) {
        boardController.post(title, content);

        return "redirect:/board";
    }

    @GetMapping("post/{boardId}")
    public String getBoard(@PathVariable Long boardId,
                           Model model) {
        Board board = boardController.getContent(boardId);

        model.addAttribute("board", board);
        return "board/board";
    }

    @GetMapping("/my-page")
    public String getMyPage(@ModelAttribute("memberDto") MemberDto memberDto, Model model) {
        MemberDto result = memberController.findLoginMemberInfo();

        Page<Board> boards = boardController.getMyBoard();
        model.addAttribute("memberDto", result);
        model.addAttribute("posts", boards.getContent());
        model.addAttribute("page", boards);
        return "my-page/my-page";
    }

    @PostMapping("/my-page/update")
    public String updateMyPage(@Validated @ModelAttribute MemberDto memberDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.memberDto", bindingResult);
            redirectAttributes.addFlashAttribute("memberDto", memberDto);
            return "redirect:/my-page";
        }
        memberController.updateMember(memberDto);
        redirectAttributes.addFlashAttribute("successMessage", "회원 정보가 성공적으로 업데이트되었습니다.");
        return "redirect:/";
    }

    @PostMapping("/members/delete")
    public String delete(RedirectAttributes redirectAttributes) {

        memberController.delete();
        redirectAttributes.addFlashAttribute("successMessage", "성공적으로 탈퇴되었습니다.");

        return "redirect:/logout";
    }
}
