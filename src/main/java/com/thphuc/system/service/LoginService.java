package com.thphuc.system.service;

import com.thphuc.system.dto.CampusDTO;
import com.thphuc.system.model.Campus;
import com.thphuc.system.repository.campus.ICampusRepository;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private ICampusRepository repository;

    public LoginService(ICampusRepository repository) {
        this.repository = repository;
    }

    public List<CampusDTO> getAllCampus() {
        List<CampusDTO> list = new ArrayList<>();
        List<Campus> campus = repository.getAll();
        for (Campus c : campus) {
            CampusDTO dto = new CampusDTO(c.getCid(), c.getCname());
            list.add(dto);
        }
        return list;
    }
}
