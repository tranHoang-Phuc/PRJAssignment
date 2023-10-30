package com.thphuc.system.service.teacher;

import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.InstructorDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.*;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.InstructorRepository;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.repository.campus.StudentRepository;

import java.util.*;

public class TeacherService {
    private InstructorRepository instructorRepository;
    private AttendanceRepository attendanceRepository;
    private StudentRepository studentRepository;

    private LessonRepository lessonRepository;

    public TeacherService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

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
            attendanceDTO.setStatus(a.getStatus());
            attendanceDTOS.add(attendanceDTO);
        }
        return attendanceDTOS;
    }
    public Map<StudentDTO, List<AttendanceDTO>> getAttendanceForStudent(String semester, String courseName, String group) {
        Map<Student, List<Attendance>> mappingAttendace = attendanceRepository.getAttendanceForStudent(semester, courseName, group);
        return converToDTO(mappingAttendace);
    }

    private Map<StudentDTO, List<AttendanceDTO>> converToDTO( Map<Student, List<Attendance>> mappingAttendace) {
        Map<StudentDTO, List<AttendanceDTO>> mapping = new LinkedHashMap<>();
        for (Map.Entry<Student, List<Attendance>> entry : mappingAttendace.entrySet()) {
            Student key = entry.getKey();
            List<Attendance> attendanceList = entry.getValue();
            List<AttendanceDTO> attendanceDTOS = convertToAttendanceDTO(attendanceList);
            StudentDTO s = converToDTO(key);
            mapping.put(s, attendanceDTOS);
        }
        return mapping;
    }

    private StudentDTO converToDTO(Student s) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSid(s.getSid());
        studentDTO.setScode(s.getScode());
        studentDTO.setFirstName(s.getFirstName());
        studentDTO.setLastName(s.getLastName());
        studentDTO.setGender(s.getGender());
        studentDTO.setPhone(s.getPhone());
        studentDTO.setEmail(s.getEmail());
        studentDTO.setImg(s.getImg());
        return studentDTO;
    }

    private InstructorDTO convertToInstructorDTO(Instructor i) {
        InstructorDTO instructorDTO = new InstructorDTO();
        instructorDTO.setInstructorID(i.getInstructorID());
        instructorDTO.setICode(i.getICode());
        instructorDTO.setFirstName(i.getFirstName());
        instructorDTO.setLastName(i.getLastName());
        instructorDTO.setPhone(i.getPhone());
        instructorDTO.setEmail(i.getEmail());
        instructorDTO.setImg(i.getImg());
        return instructorDTO;
    }
    public InstructorDTO getInstructorByAccountId(int accountId) {
        return convertToInstructorDTO(instructorRepository.getInstructorByAccountId(accountId));
    }
}
