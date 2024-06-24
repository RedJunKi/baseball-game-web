package jk.baseballgameweb.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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

    public Page<Board> findAll(Pageable pageable) {
        String jpql = "select b from Board b order by b.id desc";
        TypedQuery<Board> query = em.createQuery(jpql, Board.class);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Board> resultList = query.getResultList();

        TypedQuery<Long> countQuery = em.createQuery("select count(b) from Board b", Long.class);
        Long total = countQuery.getSingleResult();
        return new PageImpl<>(resultList, pageable, total);
    }

    public void delete(Long id) {
        String jpql = "DELETE FROM Board b WHERE b.id = :id";
        em.createQuery(jpql)
                .setParameter("id", id)
                .executeUpdate();
    }
}
