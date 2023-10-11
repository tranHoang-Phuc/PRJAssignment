package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Account;
import com.thphuc.system.model.Campus;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IRepository<Account> {
    @Override
    public List<Account> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT a FROM Account a";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        List<Account> list = query.getResultList();
        em.close();
        return list;
    }

    @Override
    public Account get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Account account = em.find(Account.class, id);
        em.close();
        return account;
    }

    @Override
    public void insert(Account account) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Account account) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(account);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Account account = em.find(Account.class, id);
        if (account != null) {
            em.remove(account);
        }
    }

    public Account get(String username, String password, int campusID) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT a FROM Account a WHERE a.username = :username AND a.password = :password AND a.campus.cid = :campusID";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setParameter("campusID", campusID);
        Account account = query.getSingleResult();
        em.close();
        return account;
    }
}
