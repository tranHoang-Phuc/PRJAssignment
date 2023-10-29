package com.thphuc.system.service.campus;

import com.thphuc.system.dto.CourseDTO;
import com.thphuc.system.model.Course;
import com.thphuc.system.repository.campus.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    private List<CourseDTO> getCourseBySemester(String semester) {
        List<Course> courses = courseRepository.getCourseBySemester(semester);
        return convertToDTO(courses);
    }
    private List<CourseDTO> convertToDTO(List<Course> courses) {
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (Course course : courses) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCourseID(course.getCourseID());
            courseDTO.setCourseName(course.getCourseName());
            courseDTOS.add(courseDTO);
        }
        return courseDTOS;
    }
}
