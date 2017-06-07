package br.unisc.socialnet.repository;

public interface IRepository<T> {

    void create(T model);
    void delete(T model);
    T findById(Long id);
    void update(T entidade);

}


