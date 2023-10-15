package com.thphuc.system.service.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.UserDTO;
import com.thphuc.system.model.Account;
import com.thphuc.system.model.Instructor;
import com.thphuc.system.model.Student;
import com.thphuc.system.repository.campus.InstructorRepository;
import com.thphuc.system.repository.campus.StudentRepository;

public class AccountService {
    private StudentRepository studentRepository;
    private InstructorRepository instructorRepository;

    public AccountService(StudentRepository studentRepository, InstructorRepository instructorRepository) {
        this.studentRepository = studentRepository;
        this.instructorRepository = instructorRepository;
    }

    public AccountService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public AccountService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public UserDTO getUserByAccountID(AccountDTO accountDTO) {
        if (accountDTO.getRole().getRoleId() == 1) {
            Instructor i = instructorRepository.get(accountDTO.getAccountID());
            UserDTO userDTO = new UserDTO();
            userDTO.setUserID(i.getInstructorID());
            userDTO.setUserCode(i.getICode());
            userDTO.setAccount(accountDTO);
            return userDTO;
        } else {
            Student s = studentRepository.getStudentByAccount(accountDTO.getAccountID());
            UserDTO userDTO = new UserDTO();
            userDTO.setUserID(s.getSid());
            userDTO.setUserCode(s.getScode());
            userDTO.setAccount(accountDTO);
            return userDTO;
        }
    }
}
