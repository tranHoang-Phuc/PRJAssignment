package com.thphuc.system.service.campus;

import com.thphuc.system.dto.CampusDTO;
import com.thphuc.system.model.Campus;
import com.thphuc.system.repository.campus.CampusRepository;
import com.thphuc.system.repository.campus.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CampusService  {
    private CampusRepository campusRepository;

    public CampusService(CampusRepository campusRepository) {
        this.campusRepository = campusRepository;
    }

    public List<CampusDTO> getAll() {
        List<CampusDTO> list = new ArrayList<>();
        List<Campus> campuses = campusRepository.getAll();
        for (Campus c : campuses) {
            CampusDTO campus = new CampusDTO();
            campus.setCid(c.getCid());
            campus.setCname(c.getCname());
            list.add(campus);
        }
        return list;
    }
}
