package jk.baseballgameweb.board;

import jk.baseballgameweb.auth.Member;
import jk.baseballgameweb.auth.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberService memberService;

    public Page<Board> getBoards(int page, int size) {
        return boardRepository.findAll(PageRequest.of(page, size));
    }

    public Board getContent(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("게시물이 없습니다."));
    }

    public Board post(BoardDto boardDto) {
        Member findMember = memberService.findByUsername(boardDto.getUsername())
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다."));
        Board board = new Board(findMember, boardDto.getTitle(), boardDto.getContent());
        findMember.getBoard().add(board);
        return boardRepository.save(board);
    }

    public void update(Long boardId, BoardDto boardDto) {
        boardRepository.update(boardId, boardDto);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
