package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domain.User;
import ir.maktab.repository.UserRepository;

import javax.persistence.EntityTransaction;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Integer> implements UserRepository {

    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public User update(User user) {
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    @Override
    public User save(User user) {
        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
        return user;
    }

    @Override
    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction.begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        transaction.commit();
    }

    @Override
    public User findByUserPass(String username, String password) {
        return entityManager.createQuery("SELECT u FROM User u WHERE username = :username AND password = :password", User.class).
                setParameter("username", username).setParameter("password", password).getSingleResult();
    }
}
