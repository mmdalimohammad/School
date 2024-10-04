import model.Course;
import model.Exam;
import util.ApplicationContext;
import util.Runner;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

public class Main {
    public static void main(String[] args) {


        try {
            ApplicationContext.getExamService().addExam(new Exam("mamadali","2024","12:30"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}