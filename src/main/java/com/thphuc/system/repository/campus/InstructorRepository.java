package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Instructor;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class InstructorRepository implements IRepository<Instructor> {

    @Override
    public List<Instructor> getAll() {
        return null;
    }

    @Override
    public Instructor get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Instructor instructor = em.find(Instructor.class, id);
        em.close();
        return instructor;
    }

    @Override
    public void insert(Instructor instructor) {

    }

    @Override
    public void update(Instructor instructor) {

    }

    @Override
    public void delete(int id) {

    }

    public Instructor getInstructorByAccountId(int accountId) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT i FROM Instructor i WHERE i.account.accountID = :accountId";
        Instructor instructor = em.createQuery(jpql, Instructor.class).setParameter("accountId", accountId).getSingleResult();
        em.close();
        return instructor;
    }
}
