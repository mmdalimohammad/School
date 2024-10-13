package runner;

import model.Course;
import model.Exam;
import util.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class RunnerCourse {
    static Scanner sc = new Scanner(System.in);

    public static void Course() {
        System.out.println("1: Add Course");
        System.out.println("2: Remove Course");
        System.out.println("3: Update Course");
        System.out.println("4: Show All Course");
        System.out.println("5: return");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                AddCourse();
                Course();
                break;
            case 2:
                removeCourse();
                Course();
                break;
            case 3:
                updateCourse();
                Course();
                break;
            case 4:
                showAllCourse();
                Course();
                break;
            case 5:
                Runner.admin();
        }
    }

    public static void AddCourse() {
        try {
            System.out.println("enter a title");
            String title = sc.nextLine();
            System.out.println("enter a unit");
            int unit = sc.nextInt();
            sc.nextLine();
            System.out.println("enter a exam Date (2000-01-01): ");
            String date = sc.nextLine();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            System.out.println("enter a Time (12:30): ");
            String time = sc.nextLine();
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            ApplicationContext.getCourseService().createCourse(new Course(title, unit));
            Course course = ApplicationContext.getCourseService().getCourseByTitle(title).get();
            ApplicationContext.getExamService().addExam(new Exam(
                    title,
                    LocalDate.of(year, month, day),
                    LocalTime.of(hour, minute),
                    course.getCourseId()
            ));
            System.out.println("exam and course successfully added");
            System.out.println("Course added");


        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    public static void removeCourse() {
        System.out.println("enter a title");
        String title = sc.nextLine();
        try {
            ApplicationContext.getCourseService().deleteCourse(title);
            System.out.println("dune remove course");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static void updateCourse() {
        System.out.println("enter a title");
        String title = sc.nextLine();
        try {
            if (ApplicationContext.getCourseService().getCourseByTitle(title) == null) {
                System.out.println("dune update course");
                return;
            }
            System.out.println("enter a unit");
            int unit = sc.nextInt();
            ApplicationContext.getCourseService().updateCourse(title, new Course(title, unit));
            System.out.println("dune update course");
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void showAllCourse() {
        ApplicationContext.getCourseService().printAllCoursesList();
    }
}
