package com.thphuc.system.service.teacher;

import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Attendance;
import com.thphuc.system.repository.campus.AttendanceRepository;

import java.util.List;
import java.util.ArrayList;

public class TeacherService {
    private AttendanceRepository attendanceRepository;

    public TeacherService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<AttendanceDTO> getAttendanceByLessonId(int lessonId) {
        return convertToLessonDTO(attendanceRepository.getAttendanceByLessonId(lessonId));
    }

    public static void main(String[] args) {
        AttendanceRepository attendanceRepository = new AttendanceRepository();
        TeacherService teacherService = new TeacherService(attendanceRepository);
        List<AttendanceDTO> attendanceDTOS = teacherService.getAttendanceByLessonId(13);
        System.out.println(attendanceDTOS.size());
    }
    private  List<AttendanceDTO> convertToLessonDTO(List<Attendance> list) {
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        for (Attendance attendance : list) {
            AttendanceDTO attendanceDTO = new AttendanceDTO();
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setSid(attendance.getStudent().getSid());
            studentDTO.setScode(attendance.getStudent().getScode());
            studentDTO.setFirstName(attendance.getStudent().getFirstName());
            studentDTO.setLastName(attendance.getStudent().getLastName());
            studentDTO.setGender(attendance.getStudent().getGender());
            studentDTO.setPhone(attendance.getStudent().getPhone());
            studentDTO.setEmail(attendance.getStudent().getEmail());
            studentDTO.setImg(attendance.getStudent().getImg());

            LessonDTO lessonDTO = new LessonDTO();
            lessonDTO.setLessonID(attendance.getLesson().getLessonID());
            lessonDTO.setGroupname(attendance.getLesson().getGroup().getGroupName());
            lessonDTO.setCourseName(attendance.getLesson().getGroup().getCourse().getCourseName());

            attendanceDTO.setStudent(studentDTO);
            attendanceDTO.setLesson(lessonDTO);
            attendanceDTO.setStatus(attendance.getStatus());
            attendanceDTO.setRecordedDay(attendance.getRecordedDay());
            attendanceDTO.setRecordedTime(attendance.getRecordedTime());
            attendanceDTO.setComment(attendance.getComment());

            attendanceDTOS.add(attendanceDTO);
        }
        return attendanceDTOS;
    }
}
