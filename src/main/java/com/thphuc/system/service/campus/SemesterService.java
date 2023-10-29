package com.thphuc.system.service.campus;

import com.thphuc.system.dto.SemesterDTO;
import com.thphuc.system.model.Semester;
import com.thphuc.system.repository.campus.IRepository;
import com.thphuc.system.repository.campus.SemesterRepository;

import java.util.List;
import java.util.ArrayList;

public class SemesterService {
    private SemesterRepository semesterRepository;

    public SemesterService (SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public List<SemesterDTO> getAll() {
        return converToDTO(semesterRepository.getAll());
    }

    public List<SemesterDTO> converToDTO(List<Semester> semesters) {
        List<SemesterDTO> semesterDTOS = new ArrayList<>();
        for (Semester semester : semesters) {
            SemesterDTO semesterDTO = new SemesterDTO();
            semesterDTO.setSemesterID(semester.getSemesterID());
            semesterDTO.setSemesterName(semester.getSemesterName());
            semesterDTOS.add(semesterDTO);
        }
        return semesterDTOS;
    }

}
