package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Student;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository implements IRepository<Student>{

    @Override
    public List<Student> getAll() {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT s FROM Student s";
        List<Student> list = em.createQuery(jpql, Student.class).getResultList();
        em.close();
        return list;
    }

    @Override
    public Student get(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    @Override
    public void insert(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
