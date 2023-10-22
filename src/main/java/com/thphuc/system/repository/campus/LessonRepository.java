package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Instructor;
import com.thphuc.system.model.Lesson;
import com.thphuc.system.util.DateTimeUtil;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.util.List;

public class LessonRepository implements IRepository<Lesson> {
    @Override
    public List<Lesson> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT l FROM Lesson l";
        List<Lesson> list = em.createQuery(jpql, Lesson.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public Lesson get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Lesson lesson = em.find(Lesson.class, id);
        em.close();
        return lesson;
    }

    @Override
    public void insert(Lesson lesson) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(lesson);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Lesson lesson) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(lesson);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Lesson lesson = em.find(Lesson.class, id);
        if (lesson != null) {
            em.remove(lesson);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Lesson> getWeeklyTimeTable(Instructor instructor) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            Date monday = DateTimeUtil.getMondayOfCurrentWeek();
            Date sunday = DateTimeUtil.getSundayOfCurrentWeek();
            String jpql = "SELECT l FROM Lesson l JOIN l.group g  " +
                    "WHERE l.instructor.iCode = :instructorid AND l.date >= :startDate AND l.date <= :endDate";
            TypedQuery<Lesson> query = em.createQuery(jpql, Lesson.class);
            query.setParameter("instructorid", instructor.getICode());
            query.setParameter("startDate", monday);
            query.setParameter("endDate", sunday);
            List<Lesson> list = query.getResultList();
            return list;
        } finally {
            em.close();
        }
    }






    public List<Lesson> getWeeklyTimeTalbe(Date monday, Date sunday, Instructor instructor) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            String jpql = "SELECT l FROM Lesson l JOIN l.group g  " +
                    "WHERE l.instructor.iCode = :instructorid " +
                    "AND l.date >= :startDate AND l.date <= :endDate";
            TypedQuery<Lesson> query = em.createQuery(jpql, Lesson.class);
            query.setParameter("instructorid", instructor.getICode());
            query.setParameter("startDate", monday);
            query.setParameter("endDate", sunday);
            List<Lesson> list = query.getResultList();
            return list;
        } finally {
            em.close();
        }
    }


}
