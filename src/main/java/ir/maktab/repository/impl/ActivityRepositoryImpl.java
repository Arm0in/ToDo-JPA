package ir.maktab.repository.impl;

import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domain.Activity;
import ir.maktab.domain.User;
import ir.maktab.repository.ActivityRepository;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ActivityRepositoryImpl extends BaseRepositoryImpl<Activity, Integer> implements ActivityRepository {

    EntityTransaction transaction = entityManager.getTransaction();

    @Override
    public Activity update(Activity activity) {
        transaction.begin();
        entityManager.persist(activity);
        transaction.commit();
        return activity;
    }

    @Override
    public Activity save(Activity activity) {
        transaction.begin();
        entityManager.persist(activity);
        transaction.commit();
        return activity;
    }

    @Override
    public Activity findById(Integer id) {
        return entityManager.find(Activity.class, id);
    }

    @Override
    public List<Activity> findAll() {
        return entityManager.createQuery("from Activity", Activity.class).getResultList();
    }

    @Override
    public void deleteById(Integer id) {
        transaction.begin();
        Activity activity = entityManager.find(Activity.class, id);
        entityManager.remove(activity);
        transaction.commit();
    }

    @Override
    public List<Activity> findUserActivities(User user) {
        return entityManager.createQuery("SELECT a from Activity a JOIN User u ON a.user.id = :id").setParameter("id", user.getId()).getResultList();
    }
}
