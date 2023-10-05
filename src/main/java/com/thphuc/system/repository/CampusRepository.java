package com.thphuc.system.repository;

import com.thphuc.system.model.Campus;
import com.thphuc.system.repository.IRepository;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CampusRepository implements IRepository<Campus> {
    @Override
    public List<Campus> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT c FROM Campus c";
        TypedQuery<Campus> query = em.createQuery(jpql, Campus.class);
        List<Campus> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Campus get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Campus campus = em.find(Campus.class, id);
        em.close();
        return campus;
    }

    @Override
    public void insert(Campus campus) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(campus);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Campus campus) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(campus);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Campus campus = em.find(Campus.class, id);
        if (campus != null) {
            em.remove(campus);
        }
        em.getTransaction().commit();
        em.close();
    }
}
