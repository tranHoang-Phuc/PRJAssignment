package com.thphuc.system.service.campus;

import com.thphuc.system.model.Lesson;
import com.thphuc.system.model.Student;
import com.thphuc.system.repository.campus.LessonRepository;

import java.util.List;
import java.sql.Date;

public class LessonService {
    private LessonRepository lessonRepository;

     public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getScheduleOfWeek(String studentID) {
         Student s = new Student();
         s.setSid(Integer.parseInt(studentID));
        return lessonRepository.getWeeklyTimeTable(s);
    }

    public List<Lesson> getScheduleOfWeek(String studentID, String monday) {
        Date mondayDate = Date.valueOf(monday);
        Date sundayDate = Date.valueOf(mondayDate.toLocalDate().plusDays(6));
        Student s = new Student();
        s.setSid(Integer.parseInt(studentID));
        return lessonRepository.getWeeklyTimeTalbe(mondayDate, sundayDate, s);
    }
}
