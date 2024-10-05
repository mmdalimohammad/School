import model.Course;
import model.Exam;
import model.Student;
import util.ApplicationContext;
import util.Runner1;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

public class Main {
    public static void main(String[] args) {

        try {
            ApplicationContext.getStudentService().createStudent(new Student("mamamamama","aaaaaaa",LocalDate.of(2006,05,14),"0151236987"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
}