package com.thphuc.system.repository.campus;

import com.thphuc.system.model.Attendance;
import com.thphuc.system.model.Student;
import com.thphuc.system.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AttendanceRepository implements IRepository<Attendance> {

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

    public List<Attendance> getAttendanceByScode(String sid, String group, String course) {
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT a FROM Attendance a WHERE a.lesson.lessonID IN (SELECT DISTINCT l.lessonID FROM Lesson l WHERE l.group.groupName=:group AND l.group.course.courseName=:course) AND a.student.sid=:sid ORDER BY a.lesson.sessionNo ASC";
        TypedQuery<Attendance> query = em.createQuery(jpql, Attendance.class);
        query.setParameter("sid", sid);
        query.setParameter("group", group);
        query.setParameter("course", course);
        List<Attendance> list = query.getResultList();
        em.close();
        return list;
    }


    public Map<Student, List<Attendance>> getAttendanceForStudent(String semester, String courseName, String group) {
        Map<Student, List<Attendance>> mappingAttendace = new LinkedHashMap<>();
        EntityManager em = JpaUtil.getEntityManager();
        String jpql = "SELECT s FROM Student s JOIN s.groups g JOIN g.course c JOIN c.semester se " +
                "WHERE se.semesterName = :semesterName AND c.courseName = :courseName AND g.groupName = :groupName";
        TypedQuery<Student> query = em.createQuery(jpql, Student.class);
        query.setParameter("semesterName", semester);
        query.setParameter("courseName", courseName);
        query.setParameter("groupName", group);
        List<Student> students = query.getResultList();

        for(Student s: students) {
            List<Attendance> attendances = getAttendanceByScode(s.getSid() +"", group, courseName);
            mappingAttendace.put(s, attendances);
        }
        return mappingAttendace;
    }
}






