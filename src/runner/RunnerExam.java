package runner;

import model.Exam;
import util.ApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class RunnerExam {
    static Scanner sc = new Scanner(System.in);
    public static void Exam() {
        System.out.println("1: Update Exam");
        System.out.println("2: Show All Exam");
        System.out.println("3: return ");
        System.out.print("Enter your choice number: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                updateExam();
                Exam();
                break;
            case 2:
                showAllExam();
                Exam();
                break;
            case 3:
                Runner.admin();







        }
    }
//    private static void removeExam(){
//        System.out.println("enter a name :");
//        String name = sc.nextLine();
//        try {
//            ApplicationContext.getExamService().deleteExam(name);
//            System.out.println("dune removed exam");
//        }catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }
//
//    }
//    private static void addExam() {
//        System.out.println("enter a Name:");
//        String name = sc.nextLine();
//        System.out.println("enter a Date (2000-01-01): ");
//        String date = sc.nextLine();
//        int year = Integer.parseInt(date.substring(0, 4));
//        int month = Integer.parseInt(date.substring(5, 7));
//        int day = Integer.parseInt(date.substring(8, 10));
//        System.out.println("enter a Time (12:30): ");
//        String time = sc.nextLine();
//        int hour = Integer.parseInt(time.substring(0, 2));
//        int minute = Integer.parseInt(time.substring(3, 5));
//        try {
//            ApplicationContext.getExamService().addExam(new Exam(name, LocalDate.of(year,month,day), LocalTime.of(hour,minute)));
//            System.out.println("dune added exam");
//        }catch (Exception exception){
//            System.out.println(exception.getMessage());
//        }
//    }
    private static void showAllExam() {
        ApplicationContext.getExamService().printAllExams();
    }
    private static void updateExam() {
        System.out.println("enter a name :");
        String name = sc.nextLine();
        try {
            if (ApplicationContext.getExamService().getExamByName(name)==null){
                System.out.println("dune updated exam");
                return;
            }
            System.out.println("enter a Date (2000-01-01): ");
            String date = sc.nextLine();
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));
            System.out.println("enter a Time (12:30): ");
            String time = sc.nextLine();
            int hour = Integer.parseInt(time.substring(0, 2));
            int minute = Integer.parseInt(time.substring(3, 5));
            ApplicationContext.getExamService().updateExam(name,new Exam(LocalDate.of(year,month,day),LocalTime.of(hour,minute)));
            System.out.println("dune updated exam");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
