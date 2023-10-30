package com.thphuc.system.service.student;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.StudentDTO;
import com.thphuc.system.model.Account;
import com.thphuc.system.model.Student;
import com.thphuc.system.repository.campus.StudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO getStudentByAccount(AccountDTO accountDTO ) {
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
        studentDTO.setPhone(s.getPhone());
        studentDTO.setEmail(s.getEmail());
        studentDTO.setImg(s.getImg());
        studentDTO.setAccount(convertToDTO(s.getAccount()));
        return studentDTO;
    }

    private AccountDTO convertToDTO (Account account) {
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
        Student s =  studentRepository.get(sid);
        return convertToDTO(s);
    }

    public StudentDTO getStudentByAccount(int accountID) {
        Student s = studentRepository.getStudentByAccount(accountID);
        return convertToDTO(s);
    }

}
