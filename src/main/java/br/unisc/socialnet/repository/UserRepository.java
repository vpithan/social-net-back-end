package br.unisc.socialnet.repository;

import br.unisc.socialnet.model.User;
import javax.persistence.Query;

public class UserRepository extends AbstractRepository<User> {

    @Override
    public User findById(Long id) {
        Query query = em.createQuery("select u from User u where u.id=:id");
        query.setParameter("id", id);
        return (User) query.getSingleResult();
    }

}
