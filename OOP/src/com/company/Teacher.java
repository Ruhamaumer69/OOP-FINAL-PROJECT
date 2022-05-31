package com.company;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

interface TeacherWork{

    void login()throws Exception;//FUNCTION FOR LOGIN
    void TeacherAttendance() throws IOException;//FUNCTION FOR TEACHER TO MARK THEIR ATTENDANCE
    void MarkAttendance() throws IOException;//FUNCTION TO MARK ATTENDANCE OF STUDENTS
    void EnterMarks() throws IOException;//FUNCTION TO ENTER MARKS OF A PARTICULAR CLASS
    void DisplayAttendance() throws IOException;//FUNCTION TO DISPLAY ATTENDANCE
    void DisplayMarks() throws IOException;//FUNCTION TO DISPLAY MARKS OF STUDENT

}


public class Teacher extends Main implements TeacherWork {
    String Username, Password,MarksObtained;
    int NoOfStudents, TotalMarks;
    String NameOfStudent;
    String RollOfStudent;
    String Attendance, SubjectName, ClassName;
    String NameOfTeacher, AttendanceOfTeacher;
    int NewNoOfStudents;
    Scanner scanner = new Scanner(System.in);

    public Teacher() throws IOException {
        super();
    }

    public String getRollOfStudent() {
        return RollOfStudent;
    }

    public String getAttendance() {
        return Attendance;
    }

    public void setRollOfStudent(String rollOfStudent) {
        RollOfStudent = rollOfStudent;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void login() throws IOException {
        int i = 0;
        boolean login = false;

        do {
            System.out.println("Enter Username");
            Username = scanner.next();
            System.out.println("Enter Password");
            Password = scanner.next();
            if (getUsername().equals("2") && getPassword().equals("2")) {
                login = true;
                break;
            } else {
                System.out.println("Access Denied");
            }
            i++;
        } while (i < 3);
        if (i == 3) {
            System.out.println("No More Attempts Left");
        }
    }

    public void TeacherAttendance() throws IOException {
        File file1 = new File("TeacherAttendance.txt");
        if (file1.createNewFile()) {
            System.out.println("File Created");
        } else {
            System.out.println("File Already Exists");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(file1));
        PrintWriter print = new PrintWriter(writer);
        System.out.println("Enter Your Name");
        NameOfTeacher = scanner.next();
        System.out.println("Enter Attendance");
        AttendanceOfTeacher = scanner.next();
        print.println("Teacher" + "    " + "Attendance" +"\n");
        print.println(NameOfTeacher + "         " + AttendanceOfTeacher+"\n");
        print.close();
    }

    public void MarkAttendance() throws IOException {
        int i = 0;
        File file = new File("Attendance.txt");
        if (file.createNewFile()) {
            System.out.println("File Created");
        } else {
            System.out.println("File Already Exists");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        PrintWriter printWriter = new PrintWriter(bufferedWriter);
        System.out.println("Enter Details");
        System.out.println("Enter Class Name");
        ClassName = scanner.next();
        System.out.println("Enter The Number Of Students In Class");
        NoOfStudents = scanner.nextInt();
        for (i = 0; i < NoOfStudents; i++) {
            System.out.println("ENTER ROLL NO");
            RollOfStudent = scanner.next();
            System.out.println("ENTER ATTENDANCE");
            Attendance = scanner.next();
            printWriter.print(RollOfStudent + " "+ Attendance+"\n");

        }
        printWriter.close();

    }

    public void EnterMarks() throws IOException {
        int i = 0;
        File file2 = new File("Marks.txt");
        if (file2.createNewFile()) {
            System.out.println("File Created");
        } else {
            System.out.println("File Already Exists");
        }
        BufferedWriter bufferedWriter1 = new BufferedWriter(new FileWriter(file2));
        PrintWriter printWriter1 = new PrintWriter(bufferedWriter1);


        System.out.println("ENTER DETAILS");
        System.out.println("Enter The No Of Students");
        NewNoOfStudents = scanner.nextInt();
        System.out.println("Start Entering The Roll No And Marks");
        for (i = 0; i < NewNoOfStudents; i++) {
            System.out.println("ROLL NO");
            RollOfStudent = scanner.next();
            System.out.println("MARKS");
            MarksObtained = scanner.next();

            printWriter1.print(RollOfStudent + " "+ MarksObtained+"\n");

        }
        printWriter1.close();

    }

    public void DisplayAttendance() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Attendance.txt"));
        String Reader;
        while ((Reader = reader.readLine()) != null) {
            System.out.println(Reader);
        }
        reader.close();

    }

    public void DisplayMarks() throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("Marks.txt"));
        String Reader1;
        while ((Reader1 = reader1.readLine()) != null) {
            System.out.println(Reader1);
        }
        reader1.close();

    }

}


