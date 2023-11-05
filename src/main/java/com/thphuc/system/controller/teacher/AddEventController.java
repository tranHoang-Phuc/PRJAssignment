package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.lesson.LessonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class AddEventController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        int lessonID = Integer.parseInt(request.getParameter("lessonId"));
        request.setAttribute("lessonId", lessonID);
        request.getRequestDispatcher("../view/teacher/add-event.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        String event = request.getParameter("event");
        int lessonID = Integer.parseInt(request.getParameter("lessonId"));
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        lessonService.update(lessonID, event);
        response.sendRedirect(request.getContextPath() + "/weeklySchedule");
    }
}
