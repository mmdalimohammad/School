package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

public class ApplicationContext {
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;
    private static final CourseRepository courseRepository;
    private static final CourseService courseService ;
    private static final ExamRepository examRepository;
    private static final ExamService examService;
    private static final CourseStudentRepository courseStudentRepository;
    private static final CourseStudentService courseStudentService;
    private static final AdminRepository adminRepository;
    private static final AdminService adminService;

    static {
        studentRepository=new StudentRepositoryImpl();
        studentService=new StudentServiceImpl(studentRepository);
        teacherRepository=new TeacherRepositoryImpl();
        teacherService=new TeacherServiceImpl(teacherRepository);
        courseRepository=new CourseRepositoryImpl();
        courseService=new CourseServiceImpl(courseRepository);
        examRepository=new ExamRepositoryImpl();
        examService=new ExamServiceImpl(examRepository);
        courseStudentRepository=new CourseStudentRepositoryImpl();
        courseStudentService=new CourseStudentServiceImpl(courseStudentRepository,courseRepository);
        adminRepository=new AdminRepositoryImpl();
        adminService=new AdminServiceImpl(adminRepository);
    }



    public static StudentService getStudentService() {
        return studentService;
    }
    public static TeacherService getTeacherService() {
        return teacherService;
    }
    public static CourseService getCourseService() {
        return courseService;
    }
    public static ExamService getExamService() {
        return examService;
    }
    public static CourseStudentService getCourseStudentService() {
        return courseStudentService;
    }
    public static AdminService getAdminService() {
        return adminService;
    }

}
