package com.thphuc.system.controller.teacher;

import com.thphuc.system.controller.authentication.BaseAuthorizationController;
import com.thphuc.system.dto.AccountDTO;
import com.thphuc.system.dto.LessonDTO;
import com.thphuc.system.model.Feature;
import com.thphuc.system.repository.campus.LessonRepository;
import com.thphuc.system.service.lesson.LessonService;
import com.thphuc.system.util.SessionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

public class ConfirmAttendanceController extends BaseAuthorizationController {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {
        int lessonId =(int)SessionUtil.getInstance().getValue(request, "lessonId");
        LessonRepository lessonRepository = new LessonRepository();
        LessonService lessonService = new LessonService(lessonRepository);
        LessonDTO lessonDTO = lessonService.getLessonById(lessonId);
        request.setAttribute("lesson", lessonDTO);
        request.getRequestDispatcher("../view/teacher/confirm-attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, AccountDTO user, Set<Feature> features) throws ServletException, IOException {

    }
}
