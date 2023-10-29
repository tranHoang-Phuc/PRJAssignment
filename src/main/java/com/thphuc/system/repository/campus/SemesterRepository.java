package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Semester;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SemesterRepository implements IRepository<Semester>{
    @Override
    public List<Semester> getAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Semester> semesters = entityManager.createQuery("SELECT s FROM Semester s", Semester.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return semesters;
    }

    @Override
    public Semester get(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Semester semester = entityManager.find(Semester.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return semester;
    }

    @Override
    public void insert(Semester semester) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(semester);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Semester semester) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(semester);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Semester semester = entityManager.find(Semester.class, id);
        entityManager.remove(semester);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
