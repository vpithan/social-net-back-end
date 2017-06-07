package br.unisc.socialnet.repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.unisc.socialnet.model.AbstractModel;

public abstract class AbstractRepository<T extends AbstractModel> implements IRepository<T> {

    protected EntityManager em;

    protected AbstractRepository() {
        em = Persistence.createEntityManagerFactory("SocialNetPU")
                .createEntityManager();
    }

    @Override
    public void create(T model) {
        begin();
        em.persist(validate(model));
        commit();
    }

    @Override
    public void delete(T model) {
        begin();
        em.remove(model);
        commit();
    }

    @Override
    public void update(T model) {
        begin();
        em.merge(validate(model));
        commit();
    }

    protected void begin() {
        em.getTransaction().begin();
    }

    protected void commit() {
        em.getTransaction().commit();
    }

    private T validate(T model) {
        if (model.getCreateAt() == null) {
            model.setCreateAt(System.currentTimeMillis());
        }
        if (model.getUpdateAt() == null) {
            model.setUpdateAt(System.currentTimeMillis());
        }
        return model;
    }

}
