package util;

import model.Course;
import model.Student;
import model.Teacher;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Runner1 {
    static Scanner sc = new Scanner(System.in);

    public static void run() {

        System.out.println("1: Student");
        System.out.println("2: Teacher");
        System.out.println("3: Course");
        System.out.println("4: Exit");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Student();
                break;
            case 2:
                Teacher();
                break;
            case 3:
                Course();
                break;
            case 4:
                return;
        }

    }

    private static void studentSignInMenu() {

        System.out.println("1 - sign in");
        System.out.println("2 - sign up");
        System.out.println("4 - exit");
        System.out.println("Enter your choice number:");
        Integer choice = sc.nextInt();
        switch (choice) {
            case 1:
                studentSignInMenu();
                break;
            case 2:
                studentSignInMenu();
                break;
            case 3:
                return;
        }
    }

}

private static void Course() {
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
            return;
    }
}

private static void AddCourse() {
    System.out.println("enter a title");
    String title = sc.nextLine();
    System.out.println("enter a unit");
    int unit = sc.nextInt();
    Course course = new Course(title, unit);
    try {
        ApplicationContext.getCourseService().createCourse(course);
        System.out.println("dune add course");
    } catch (Exception exception) {
        System.out.println(exception.getMessage());
    }

}

private static void removeCourse() {
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

private static void showAllCourse() {
    ApplicationContext.getCourseService().printAllCoursesList();
}

private static void Student() {
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
            run();
    }


}

private static void Teacher() {
    System.out.println("1: Add Teacher");
    System.out.println("2: Remove Teacher");
    System.out.println("3: Update Teacher");
    System.out.println("4: Show All Teacher");
    System.out.println("5: return ");
    System.out.print("Enter your choice number: ");
    int choice = sc.nextInt();
    sc.nextLine();
    switch (choice) {
        case 1:
            addTeacher();
            Teacher();
            break;
        case 2:
            removeTeacher();
            Teacher();
            break;
        case 3:
            updateTeacher();
            Teacher();
            break;
        case 4:
            showAllTeacher();
            Teacher();
            break;
        case 5:
            run();
    }


}

private static void addStudent() {
    try {
        System.out.println("enter first name:");
        String firstName = sc.nextLine();
        System.out.println("enter last name:");
        String lastName = sc.nextLine();
        System.out.println("enter birth date:");
        String birthDate = sc.nextLine();
        int year = Integer.parseInt(birthDate.substring(0, 4));
        int month = Integer.parseInt(birthDate.substring(5, 7));
        int day = Integer.parseInt(birthDate.substring(8, 10));
        System.out.println("enter national code:");
        String nationalCode = sc.nextLine();
        ApplicationContext.getStudentService().createStudent(new Student(firstName, lastName, LocalDate.of(year, month, day), nationalCode));
    } catch (Exception exception) {
        System.out.println(exception.getMessage());
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

private static void updateStudent() {
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
        System.out.println("enter birth date:");
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

private static void addTeacher() {
    System.out.println("enter a first name:");
    String firstName = sc.nextLine();
    System.out.println("enter a last name:");
    String lastName = sc.nextLine();
    System.out.println("enter a national Code:");
    String nationalCode = sc.next();
    Teacher teacher = new Teacher(firstName, lastName, nationalCode);
    try {
        ApplicationContext.getTeacherService().createTeacher(teacher);
        System.out.println("dune add teacher");
    } catch (Exception Exception) {
        System.out.println(Exception.getMessage());
    }
}

private static void removeTeacher() {
    System.out.println("enter a national Code:");
    String nationalCode = sc.next();
    try {
        ApplicationContext.getTeacherService().removeTeacher(nationalCode);
        System.out.println("dune removed teacher");
    } catch (Exception Exception) {
        System.out.println(Exception.getMessage());
    }
}

private static void updateTeacher() {
    System.out.println("enter a national Code:");
    String nationalCode = sc.nextLine();
    try {
        if (ApplicationContext.getTeacherService().getTeacherNationalCode(nationalCode) == null) {
            System.out.println("dune update teacher");
            return;
        }
        System.out.println("enter first name:");
        String firstName = sc.nextLine();
        System.out.println("enter last name:");
        String lastName = sc.nextLine();
        ApplicationContext.getTeacherService().updateTeacher(nationalCode, new Teacher(firstName, lastName, nationalCode));
        System.out.println("dune update teacher");
    } catch (Exception exception) {
        System.out.println(exception.getMessage());
    }
}

private static void showAllTeacher() {
    ApplicationContext.getTeacherService().printAllTeacherList();
}
}
