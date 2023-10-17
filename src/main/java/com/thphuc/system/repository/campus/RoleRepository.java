package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Role;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class RoleRepository implements IRepository<Role> {
    @Override
    public List<Role> getAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        List<Role> roles = entityManager.createQuery("SELECT r FROM Role r", Role.class).getResultList();
        entityManager.close();
        return roles;
    }

    @Override
    public Role get(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        Role role = entityManager.find(Role.class, id);
        entityManager.close();
        return role;
    }

    @Override
    public void insert(Role role) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Role role) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Role role = entityManager.find(Role.class, id);
        entityManager.remove(role);
        entityManager.getTransaction().commit();
        entityManager.close();
    }




}
