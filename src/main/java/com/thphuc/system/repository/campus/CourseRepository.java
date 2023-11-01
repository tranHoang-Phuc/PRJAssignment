package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Course;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CourseRepository implements IRepository<Course>{
    @Override
    public List<Course> getAll() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    @Override
    public Course get(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }


    @Override
    public void insert(Course course) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void update(Course course) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Course> getCourseBySemester(String semester) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager.createQuery("SELECT c FROM Course c WHERE c.semester.semesterName = :semester", Course.class)
                .setParameter("semester", semester)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    public List<Course> getCourseBySemesterAndStudentCode(String semester, String sid) {
        EntityManager entityManager = JpaUtil.getEntityManager();
        String jpql = "SELECT c FROM Course c JOIN c.semester s WHERE s.semesterName = :semester AND c.courseID IN(SELECT g.course.courseID FROM Group g JOIN g.students s WHERE s.sid = :sid)";
        TypedQuery<Course> query = entityManager.createQuery(jpql, Course.class);
        query.setParameter("semester", semester);
        query.setParameter("sid", sid);
        List<Course> courses = query.getResultList();
        entityManager.close();
        return courses;
    }


}
