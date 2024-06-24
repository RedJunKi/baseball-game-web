package jk.baseballgameweb.board;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public Page<Board> getBoards(int page, int size) {
        return boardService.getBoards(page, size);
    }

    @GetMapping("/{boardId}")
    public Board getContent(@PathVariable Long boardId) {
        return boardService.getContent(boardId);
    }

    @PostMapping("/post")
    public Board post(String title, String content) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        if (username.equals("anonymousUser")) {
            throw new IllegalStateException("회원이 아닙니다.");
        }

        return boardService.post(new BoardDto(username, title, content));
    }

    @PostMapping("/{boardId}")
    public void update(@PathVariable Long boardId, @RequestBody BoardDto boardDto) {
        //작성한 멤버 id와 현재 로그인중인 멤버 id가 일치하는지 확인
        boardService.update(boardId, boardDto);

        //리턴값 필요할 수 있음
    }

    @PostMapping("/delete/{boardId}")
    public String delete(@PathVariable Long boardId, Principal principal, RedirectAttributes redirectAttributes) {
        //작성한 멤버 id와 현재 로그인중인 멤버 id가 일치하는지 확인
        Board board = boardService.getContent(boardId);
        String loggedInUsername = principal.getName();

        if (board.getMember().getUsername().equals(loggedInUsername)) {
            // 게시물 삭제 로직
            boardService.delete(boardId);
            redirectAttributes.addFlashAttribute("successMessage", "게시물이 성공적으로 삭제되었습니다.");
        } else {
            // 삭제 권한이 없는 경우 처리
            redirectAttributes.addFlashAttribute("errorMessage", "삭제 권한이 없습니다.");
        }

        return "redirect:/board";
    }
}
