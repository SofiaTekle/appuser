package se.iths.sofia.appuser.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import se.iths.sofia.appuser.entity.AppUser;

import java.util.List;

@ApplicationScoped
public class AppUserJpaRepository implements AppUserRepository {

    @PersistenceContext(unitName = "neon-database")
    private EntityManager em;

    @Override
    public AppUser save(AppUser user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<AppUser> findAll() {
        return em.createQuery("SELECT u FROM AppUser u", AppUser.class)
                .getResultList();
    }

    @Override
    public AppUser findByUsername(String username) {
        return em.createQuery("SELECT u FROM AppUser u WHERE u.username = :username", AppUser.class)
                .setParameter("username", username)
                .getResultStream()
                .findFirst()
                .orElse(null);
    }

}
