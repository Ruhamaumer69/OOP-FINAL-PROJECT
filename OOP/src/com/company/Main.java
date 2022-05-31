package com.company;
import java.util.*;


public class Main  {

    protected static Scanner x;
    protected static Scanner y;
    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        String filepath = "StudentData.txt";
        String filepath1 = "TeacherData.txt";
        String filePath2 = "Attendance.txt";
        String filePath3 = "Marks.txt";
        String continue1;
        System.out.println("Welcome To School Management System");
        System.out.println("Enter The Section You Want To Access");
        System.out.println("1. FOR ADMIN");
        System.out.println("2. FOR TEACHER");
        System.out.println("3. FOR STUDENT");

        int Section = scanner.nextInt();

        switch(Section)
        {
            case 1:
                Admin admin = new Admin();
                admin.login();
                do {
                    System.out.println("WELCOME ADMIN");
                    System.out.println("Enter The Operation You Want To Perform");
                    System.out.println("1. ADD STUDENT");
                    System.out.println("2. DELETE STUDENT");
                    System.out.println("3. MODIFY RECORD OF STUDENT");
                    System.out.println("4. ADD TEACHER");
                    System.out.println("5. DELETE TEACHER");
                    System.out.println("6. MODIFY RECORD OF TEACHER");
                    int Operation = scanner.nextInt();
                    switch (Operation) {
                        case 1:
                            admin.AddStudent();
                            break;
                        case 2:
                            System.out.println("ENTER ROLL NO YOU WANT TO REMOVE");
                            String roll = scanner.next();
                            admin.DeleteStudent(filepath, roll);
                            break;
                        case 3:
                            //        System.out.println("ENTER THE TERM YOU WANT TO EDIT");
//                                String EditTerm = scanner.next();
//                                System.out.println("ENTER THE NAME");
//                                String NewName= scanner.next();
//                                System.out.println("ENTER THE THE AGE");
//                                String NewAge = scanner.next();
//                                System.out.println("ENTER THE ROLL NO");
//                                String NewRoll = scanner.next();
//                                System.out.println("ENTER THE CLASS");
                            //                        String NewClass = scanner.next();

                            admin.ModifyStudent("3096", "taha", "18", "3114", "14", filepath);
                            break;
                        case 4:
                            admin.AddTeacher();
                            break;
                        case 5:
                            System.out.println("ENTER THE NAME OF TEACHER YOU WANT TO REMOVE");
                            String Tname = scanner.next();
                            admin.DeleteTeacher(filepath1, "taha");
                            break;
                        case 6:
//                        System.out.println("ENTER THE TERM YOU WANT TO EDIT");
//                        String EditTerm1 = scanner.next();
//                        System.out.println("ENTER THE NAME");
//                        String NewName1 = scanner.next();
//                        System.out.println("ENTER THE AGE");
//                        String NewAge1 = scanner.next();
//                        System.out.println("ENTER THE SALARY");
//                        String NewSalary = scanner.next();
//                        System.out.println("ENTER QUALIFICATION");
//                        String NewQuali = scanner.next();
                            admin.ModifyTeacher("ruhama", "taha", "19", "10000", "mbbs", filepath1);
                            break;
                        default:
                            System.out.println("invalid input");
                    }
                    System.out.println("DO YOU WANT TO CONTINUE");
                    continue1 = scanner.next();
                }while (continue1.equals("y")||continue1.equals("Y"));
                break;
            case 2:
                Teacher teacher = new Teacher();
                teacher.login();
                String Continue;
                int i = 0;
             do
            {
                System.out.println("WELCOME TEACHER");
                System.out.println("Enter The Operation You Want To Perform");
                System.out.println("1. Mark Your Attendance");
                System.out.println("2. Mark Attendance Of Students");
                System.out.println("3. Enter Marks");
                System.out.println("4. Display Attendance");
                System.out.println("5. Display Marks");
                System.out.println("6. Exit");


                int TeacherOperation = scanner.nextInt();
                switch (TeacherOperation) {
                    case 1:
                        teacher.TeacherAttendance();
                        break;
                    case 2:
                        teacher.MarkAttendance();
                        break;
                    case 3:
                        teacher.EnterMarks();
                        break;
                    case 4:
                        teacher.DisplayAttendance();
                        break;
                    case 5:
                        teacher.DisplayMarks();
                        break;
                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("INVALID INPUT");
                }


                System.out.println("Do You Want To Continue");
                Continue = scanner.next();

            }while(Continue.equals("y")||Continue.equals("Y"));
             break;

            case 3:
                        Student student = new Student();
                        student.login();
                        String cont,rollNo;
                        do {
                            System.out.println("ENTER THE OPERATION YOU WANT TO PERFORM");
                            System.out.println("1. DISPLAY ATTENDANCE");
                            System.out.println("2. DISPLAY MARKS");
                            System.out.println("3. EXIT");
                            int StudentOperation = scanner.nextInt();
                            switch(StudentOperation)
                            {
                                case 1:
                                    System.out.println("ENTER ROLL NO");
                                    rollNo = scanner.next();
                                    student.displayAttendance(rollNo,filePath2);
                                    break;
                                case 2:
                                    System.out.println("ENTER ROLL NO");
                                    rollNo = scanner.next();
                                    student.displayMarks(rollNo,filePath3);
                                    break;


                            }
                            System.out.println("DO YOU WANT TO CONTINUE");
                            cont = scanner.next();
                        }while(cont.equals("y")||cont.equals("Y"));

                break;
        }
    }
}