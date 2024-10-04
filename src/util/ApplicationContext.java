package util;

import repository.CourseRepository;
import repository.ExamRepository;
import repository.StudentRepository;
import repository.TeacherRepository;
import repository.impl.CourseRepositoryImpl;
import repository.impl.ExamRepositoryImpl;
import repository.impl.StudentRepositoryImpl;
import repository.impl.TeacherRepositoryImpl;
import service.CourseService;
import service.ExamService;
import service.StudentService;
import service.TeacherService;
import service.impl.CourseServiceImpl;
import service.impl.ExamServiceImpl;
import service.impl.StudentServiceImpl;
import service.impl.TeacherServiceImpl;

public class ApplicationContext {
    private static final StudentRepository studentRepository;
    private static final StudentService studentService;
    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;
    private static final CourseRepository courseRepository;
    private static final CourseService courseService ;
    private static final ExamRepository examRepository;
    private static final ExamService examService;


    static {
        studentRepository=new StudentRepositoryImpl();
        studentService=new StudentServiceImpl(studentRepository);
        teacherRepository=new TeacherRepositoryImpl();
        teacherService=new TeacherServiceImpl(teacherRepository);
        courseRepository=new CourseRepositoryImpl();
        courseService=new CourseServiceImpl(courseRepository);
        examRepository=new ExamRepositoryImpl();
        examService=new ExamServiceImpl(examRepository);
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

}
