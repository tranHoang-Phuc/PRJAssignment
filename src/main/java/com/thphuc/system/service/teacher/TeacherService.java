package com.thphuc.system.service.teacher;

import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Attendance;
import com.thphuc.system.model.Lesson;
import com.thphuc.system.model.Student;
import com.thphuc.system.model.TimeSlot;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.repository.campus.StudentRepository;

import java.util.List;
import java.util.ArrayList;

public class TeacherService {
    private AttendanceRepository attendanceRepository;
    private StudentRepository studentRepository;

    private LessonRepository lessonRepository;

    public TeacherService(AttendanceRepository attendanceRepository, StudentRepository studentRepository, LessonRepository lessonRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.lessonRepository = lessonRepository;
    }

    public TeacherService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public TeacherService(AttendanceRepository attendanceRepository, StudentRepository studentRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
    }


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

    public void updateAttendance(AttendanceDTO attendanceDTO) {
        attendanceRepository.update(convertToAttendance(attendanceDTO));
    }

    public Attendance convertToAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = new Attendance();
        Student s = studentRepository.get(attendanceDTO.getStudent().getSid());
        attendance.setStudent(s);
        Lesson l = lessonRepository.get(attendanceDTO.getLesson().getLessonID());
        l.setAttendanceStatus(true);
        lessonRepository.update(l);
        attendance.setLesson(l);
        attendance.setRecordedDay(attendanceDTO.getRecordedDay());
        attendance.setRecordedTime(attendanceDTO.getRecordedTime());
        attendance.setStatus(attendanceDTO.getStatus());
        attendance.setComment(attendanceDTO.getComment());
        return attendance;
    }

    public List<AttendanceDTO> getAttendanceByScode(String scode, String group, String course) {
        List<Attendance> attendances =  attendanceRepository.getAttendanceByScode(scode, group, course);
        return convertToAttendanceDTO(attendances);
    }
    public List<AttendanceDTO> convertToAttendanceDTO(List<Attendance> attendances) {
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        for (Attendance a: attendances){
            AttendanceDTO attendanceDTO = new AttendanceDTO();
            LessonDTO lessonDTO = new LessonDTO();
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setTimeSlotID(a.getLesson().getTimeSlot().getTimeSlotID());
            lessonDTO.setInstructorCode(a.getLesson().getInstructor().getICode());
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setSid(a.getStudent().getSid());
            attendanceDTO.setStudent(studentDTO);
            attendanceDTO.setGroupName(a.getLesson().getGroup().getGroupName());
            attendanceDTO.setSlotId(a.getLesson().getTimeSlot().getTimeSlotID());
            attendanceDTO.setRoomName(a.getLesson().getRoom().getRoomName());
            lessonDTO.setGroupname(a.getLesson().getGroup().getGroupName());
            lessonDTO.setDate(a.getLesson().getDate());
            attendanceDTO.setLesson(lessonDTO);
            attendanceDTOS.add(attendanceDTO);
        }
        return attendanceDTOS;
    }
}
