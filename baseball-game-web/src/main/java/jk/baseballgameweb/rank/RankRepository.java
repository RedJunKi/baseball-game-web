package jk.baseballgameweb.rank;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Repository
@Transactional
public class RankRepository {

    private final EntityManager em;

    public RankRepository(EntityManager em) {
        this.em = em;
    }

    public Rank save(Rank rank) {
        em.persist(rank);
        return rank;
    }




}
