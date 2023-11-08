package com.thphuc.system.service.lesson;

import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.model.Instructor;
import com.thphuc.system.model.Lesson;
import com.thphuc.system.model.Student;
import com.thphuc.system.repository.campus.LessonRepository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class LessonService {
    private LessonRepository lessonRepository;

     public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> getScheduleOfWeek(String instructorCode) {
        Instructor instructor = new Instructor();
        instructor.setICode(instructorCode);
        return lessonRepository.getWeeklyTimeTable(instructor);
    }

    public List<LessonDTO> convertToDTO(List<Lesson> lessons) {
         List<LessonDTO> lessonDTOs = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setLessonID(lesson.getLessonID());
            lessonDTO.setGroupname(lesson.getGroup().getGroupName());
            lessonDTO.setCourseName(lesson.getGroup().getCourse().getCourseName());
            lessonDTO.setRoomName(lesson.getRoom().getRoomName());
            lessonDTO.setTimeSlot(lesson.getTimeSlot().getTimeSlotID() + "");
            lessonDTO.setTimeLast(lesson.getTimeSlot().getStartTime() + " - " + lesson.getTimeSlot().getEndTime());
            lessonDTO.setDate(lesson.getDate());
            lessonDTO.setSessionNo(lesson.getSessionNo());
            lessonDTO.setAttendanceStatus(lesson.getAttendanceStatus());
            lessonDTO.setEvent(lesson.getEvent());
            lessonDTOs.add(lessonDTO);
        }
        return lessonDTOs;
    }


    public List<Lesson> getScheduleOfWeek(String iCode, String monday) {
        Date mondayDate = Date.valueOf(monday);
        Date sundayDate = Date.valueOf(mondayDate.toLocalDate().plusDays(6));
        Instructor instructor = new Instructor();
        instructor.setICode(iCode);
        return lessonRepository.getWeeklyTimeTalbe(mondayDate, sundayDate, instructor);
    }

    public LessonDTO getLessonById(int id) {
        Lesson lesson = lessonRepository.get(id);
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setLessonID(lesson.getLessonID());
        lessonDTO.setInstructorCode(lesson.getInstructor().getICode());
        lessonDTO.setGroupname(lesson.getGroup().getGroupName());
        lessonDTO.setCourseName(lesson.getGroup().getCourse().getCourseName());
        lessonDTO.setRoomName(lesson.getRoom().getRoomName());
        lessonDTO.setTimeSlot(lesson.getTimeSlot().getTimeSlotID() + "");
        lessonDTO.setTimeLast(lesson.getTimeSlot().getStartTime() + " - " + lesson.getTimeSlot().getEndTime());
        lessonDTO.setDate(lesson.getDate());
        lessonDTO.setEvent(lesson.getEvent());
        lessonDTO.setSessionNo(lesson.getSessionNo());
        lessonDTO.setAttendanceStatus(lesson.getAttendanceStatus());
        return lessonDTO;
    }


    public List<LessonDTO> getStudentScheduleOfWeek(String studentCode) {
         Student s = new Student();
         s.setScode(studentCode);
        return convertToDTO(lessonRepository.getStudentWeeklyTimeTable(s));
    }

    public List<LessonDTO> getStudentScheduleOfWeek(String sCode, String monday) {
        Date mondayDate = Date.valueOf(monday);
        Date sundayDate = Date.valueOf(mondayDate.toLocalDate().plusDays(6));
        Student instructor = new Student();
        instructor.setScode(sCode);
        return convertToDTO(lessonRepository.getStudentWeeklyTimeTable(mondayDate, sundayDate, instructor));
    }

    public void update(int lessonId, String event) {
        lessonRepository.update(lessonId, event);
    }

}
