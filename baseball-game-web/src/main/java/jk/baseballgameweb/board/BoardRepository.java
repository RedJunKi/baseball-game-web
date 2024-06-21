package jk.baseballgameweb.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public Board save(Board board) {

        em.persist(board);

        return board;
    }

    public void update(Long boardId, BoardDto boardDto) {
        Board target = em.find(Board.class, boardId);
        target.setTitle(boardDto.getTitle());
        target.setContent(boardDto.getContent());
    }

    public Optional<Board> findById(Long id) {
        Board result = em.find(Board.class, id);
        return Optional.ofNullable(result);
    }

    public List<Board> findAll() {
        String jpql = "select b from Board b";
        TypedQuery<Board> result = em.createQuery(jpql, Board.class);
        return result.getResultList();
    }

    public void delete(Long id) {
        String jpql = "DELETE FROM Board b WHERE b.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }
}
