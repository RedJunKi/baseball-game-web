package jk.baseballgameweb.homecontroller;

import jk.baseballgameweb.board.Board;
import jk.baseballgameweb.board.BoardController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BoardController boardController;

    @GetMapping
    public String home() {
        return "fragments/home";
    }

    @GetMapping("board")
    public String board(Model model) {
        List<Board> boards = boardController.getAllTitle(model);

        model.addAttribute("posts", boards);
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

        return board(model);
    }

    @GetMapping("post/{boardId}")
    public String getBoard(@PathVariable Long boardId,
                           Model model) {
        Board board = boardController.getContent(boardId);

        model.addAttribute("board", board);
        return "board/board";
    }
}
