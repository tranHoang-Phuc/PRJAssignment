package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Attendance;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class AttendanceRepository implements IRepository<Attendance>{

    @Override
    public List<Attendance> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT a FROM Attendance a";
        List<Attendance> list = em.createQuery(jpql, Attendance.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public Attendance get(int id) {
        return null;
    }

    @Override
    public void insert(Attendance attendance) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(attendance);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Attendance attendance) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(attendance);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        return;
    }

    public void update(List<Attendance> list) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        for (Attendance attendance : list) {
            em.merge(attendance);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Attendance> getAttendanceByLessonId(int lessonId) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT a FROM Attendance a  WHERE a.lesson.lessonID = :lessonId";
        List<Attendance> list = em.createQuery(jpql, Attendance.class).setParameter("lessonId", lessonId).getResultList();
        em.close();
        return list;
    }




}
