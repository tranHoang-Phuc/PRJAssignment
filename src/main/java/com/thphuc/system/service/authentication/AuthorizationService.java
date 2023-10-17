package com.thphuc.system.service.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.FeatureDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.FeatureRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthorizationService {
    private FeatureRepository featureRepository;

    public AuthorizationService(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    public Set<Feature> getFeatureByRole(AccountDTO accountDTO, String url) {
        Set<Feature> features= featureRepository.getFeatureByRole(accountDTO.getRole().getRoleId(), url);
        return features;
    }


}
