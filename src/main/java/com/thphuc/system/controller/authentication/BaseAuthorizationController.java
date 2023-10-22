package com.thphuc.system.controller.authentication;

import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.FeatureDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.FeatureRepository;
import com.thphuc.system.service.authentication.AuthorizationService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public abstract class BaseAuthorizationController extends BasedRequiredAuthenticationController{
    public boolean isAuthorized(AccountDTO account, String url) {
        FeatureRepository featureRepository = new FeatureRepository();
        AuthorizationService authorizationService = new AuthorizationService(featureRepository);
        Set<Feature> featureDTOList = authorizationService.getFeatureByRole(account, url);
        account.getRole().setFeatures(featureDTOList);
        return !featureDTOList.isEmpty();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        if (isAuthorized(user, request.getServletPath())) {
            doGet(request, response, user, user.getRole().getFeatures());
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException;
    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user) throws ServletException, IOException {
        if (isAuthorized(user, request.getServletPath())) {
            doPost(request, response, user, user.getRole().getFeatures());
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
        }
    }
}
