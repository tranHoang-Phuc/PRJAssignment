package com.thphuc.system.service.student;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.AttendanceDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Account;
import com.thphuc.system.model.Attendance;
import com.thphuc.system.model.Student;
import com.thphuc.system.model.TimeSlot;
import com.thphuc.system.repository.campus.AttendanceRepository;
import com.thphuc.system.repository.campus.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;
    private AttendanceRepository attendanceRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    public StudentDTO getStudentByAccount(AccountDTO accountDTO) {
        Student s = studentRepository.getStudentByAccount(accountDTO.getAccountID());
        return convertToDTO(s);
    }

    private StudentDTO convertToDTO(Student s) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSid(s.getSid());
        studentDTO.setScode(s.getScode());
        studentDTO.setFirstName(s.getFirstName());
        studentDTO.setLastName(s.getLastName());
        studentDTO.setGender(s.getGender());
        studentDTO.setDob(s.getDob());
        studentDTO.setPhone(s.getPhone());
        studentDTO.setEmail(s.getEmail());
        studentDTO.setImg(s.getImg());
        studentDTO.setAccount(convertToDTO(s.getAccount()));
        return studentDTO;
    }

    private AccountDTO convertToDTO(Account account) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountID(account.getAccountID());
        accountDTO.setUsername(account.getUsername());
        accountDTO.setRole(account.getRole());
        accountDTO.setCampus(account.getCampus());
        return accountDTO;
    }

    public StudentDTO getStudentBySid(int sid) {
        Student s = studentRepository.get(sid);
        return convertToDTO(s);
    }

    public StudentDTO get(int sid) {
        Student s = studentRepository.get(sid);
        return convertToDTO(s);
    }

    public StudentDTO getStudentByAccount(int accountID) {
        Student s = studentRepository.getStudentByAccount(accountID);
        return convertToDTO(s);
    }

    public StudentDTO getStudentByAccountId(int accountID) {
        return convertToDTO(studentRepository.getStudentByAccount(accountID));
    }

    public List<AttendanceDTO> getAttendanceByCourseAndSid(String semester, String course, String sid) {
        return convertToAttendanceDTO(attendanceRepository.getAttendanceByCourseAndSid(semester, course, sid));
    }

    public List<AttendanceDTO> convertToAttendanceDTO(List<Attendance> attendances) {
        List<AttendanceDTO> attendanceDTOS = new ArrayList<>();
        for (Attendance a : attendances) {
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

}
