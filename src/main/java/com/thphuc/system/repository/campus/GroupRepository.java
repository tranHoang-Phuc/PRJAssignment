package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Group;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityResult;

import java.util.List;

public class GroupRepository implements IRepository<Group> {
    @Override
    public List<Group> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT g FROM Group g";
        List<Group> list = em.createQuery(jpql, Group.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public Group get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Group group = em.find(Group.class, id);
        em.close();
        return group;
    }

    @Override
    public void insert(Group group) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(group);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Group group) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(group);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Group group = em.find(Group.class, id);
        if (group != null) {
            em.remove(group);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Group> getGroupBySemesterCourse(String courseName, String semester) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT g From Group g JOIN g.course c JOIN c.semester s WHERE c.courseName = :courseName AND s.semesterName = :semester";
        List<Group> groups = em.createQuery(jpql, Group.class).setParameter("courseName", courseName).setParameter("semester", semester).getResultList();
        em.close();
        return groups;
    }


}
