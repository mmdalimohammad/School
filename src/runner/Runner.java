package runner;

import util.ApplicationContext;

import java.util.Scanner;

public class Runner {
    static Scanner sc = new Scanner(System.in);

    public static void run() {

        System.out.println("1: Admin");
        System.out.println("2: sing in");
        System.out.println("3: sing up");
        System.out.println("4: Exit");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                admin();
                break;
            case 2:
                signInStAndTe();
                break;
            case 3:
                signUpStAndTe();
                break;
            case 4:
                return;
        }


    }

    private static void admin() {
        System.out.println("1: Student");
        System.out.println("2: Teacher");
        System.out.println("3: Course");
        System.out.println("4: Exam");
        System.out.print("Enter your choice number:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                RunnerStudent.Student();
                break;
            case 2:
                RunnerTeacher.Teacher();
                break;
            case 3:
                RunnerCourse.Course();
                break;
            case 4:
                RunnerExam.Exam();
        }
    }


    private static void signInStAndTe() {

        System.out.println("****welcome****");
        System.out.println("1 - student sing in");
        System.out.println("2 - teacher sing in");
        System.out.println("3 - exit");
        System.out.println("enter a number");
        int number = sc.nextInt();

        switch (number) {
            case 1:
                signInStudent();
                student();
                break;
            case 2:
                break;
            case 3:
                return;
        }
    }

    private static void signUpStAndTe() {

        System.out.println("****welcome****");
        System.out.println("1 - student sing up");
        System.out.println("2 - teacher sing up");
        System.out.println("3 - exit");
        System.out.println("enter a number");
        int number = sc.nextInt();

        switch (number) {
            case 1:
                RunnerStudent.addStudent();
                break;
            case 2:
                RunnerTeacher.addTeacher();
                break;
            case 3:
                return;
        }
    }

    private static void signInStudent() {
        try {
            System.out.println("enter student id: ");
            int id = sc.nextInt();
            System.out.println("enter national code: ");
            String nationalCode = sc.next();
            if (ApplicationContext.getStudentService().signInStudent(id, nationalCode)) {
                System.out.println("student sign in success");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void student() {

        System.out.println("1 - add courses");
        System.out.println("2 - remove courses");
        System.out.println("3 - Show All courses");
        System.out.println("4 - show My courses");
        System.out.println("5 - edit information");
        System.out.println("6 - return to last page");
        System.out.println("enter a number");
        int number = sc.nextInt();
        switch (number) {
            case 1:
                RunnerCourse.AddCourse();
                student();
                break;
            case 2:
                RunnerCourse.removeCourse();
                student();
                break;
            case 3:
                RunnerCourse.showAllCourse();
                student();
                break;
            case 4:
                student();
                break;
            case 5:
                RunnerStudent.updateStudent();
                student();
                break;
            case 6:
                return;
        }

    }


}
