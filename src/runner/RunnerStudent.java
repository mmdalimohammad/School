package runner;

import model.Student;
import model.dto.CourseDto;
import util.ApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RunnerStudent {
    static Scanner sc = new Scanner(System.in);
    public static void Student() {
        System.out.println("1: Add Student");
        System.out.println("2: Remove Student");
        System.out.println("3: Update Student");
        System.out.println("4: Show All Student");
        System.out.println("5: return");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                addStudent();
                Student();
                break;

            case 2:
                removeStudent();
                Student();
                break;
            case 3:
                updateStudent();
                Student();
                break;
            case 4:
                showAllStudent();
                Student();
                break;
            case 5:

        }


    }
    public static void addStudent() {
        System.out.println("enter a first name:");
        String firstName = sc.nextLine();
        System.out.println("enter a last name:");
        String lastName = sc.nextLine();
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        System.out.println("enter a birthDate:");
        String birthDate = sc.nextLine();
        int year = Integer.parseInt(birthDate.substring(0, 4));
        int month = Integer.parseInt(birthDate.substring(5, 7));
        int day = Integer.parseInt(birthDate.substring(8, 10));
        Student student = new Student(firstName, lastName, LocalDate.of(year, month, day), nationalCode);
        try {
            ApplicationContext.getStudentService().createStudent(student);
            System.out.println("dune add Student");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }


    }
    private static void removeStudent() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.next();
        try {
            ApplicationContext.getStudentService().removeStudent(nationalCode);
            System.out.println("dune removed student");
        } catch (Exception Exception) {
            System.out.println(Exception.getMessage());
        }


    }
    public static void updateStudent() {
        System.out.println("enter a national Code:");
        String nationalCode = sc.nextLine();
        try {
            if (ApplicationContext.getStudentService().getStudentNationalCode(nationalCode) == null) {
                System.out.println("dune update Student");
                return;
            }
            System.out.println("enter first name:");
            String firstName = sc.nextLine();
            System.out.println("enter last name:");
            String lastName = sc.nextLine();
            System.out.println("enter a birthDate -> (2000-01-01):");
            String birthDate = sc.nextLine();
            int year = Integer.parseInt(birthDate.substring(0, 4));
            int month = Integer.parseInt(birthDate.substring(5, 7));
            int day = Integer.parseInt(birthDate.substring(8, 10));
            ApplicationContext.getStudentService().updateStudent(nationalCode, new Student(firstName, lastName, LocalDate.of(year, month, day), nationalCode));
            System.out.println("dune update Student");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
    private static void showAllStudent() {
        ApplicationContext.getStudentService().printAllStudentList();
    }
    public static void showMyCourse(){
        try {
            List<CourseDto> courses=ApplicationContext.getCourseStudentService().getCourses();
            System.out.printf("%-13s %-5 %-20s %-13s %-13s\n","title","credit","teacher", "date","time");
            for (CourseDto course : courses) {
                System.out.printf("%-13s %-5 %-20s %-13s %-13s\n", course.getCourseTitle(), course.getCourseUnit(), course.getTeacherName(), course.getExamDate(), course.getExamTime());
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }

    }
}
