package com.company;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

interface StudentWork{
    void login();
    void displayAttendance(String rollNo , String filePath2);
    void displayMarks(String rollNo , String filePath3);

}
public class Student extends Teacher implements StudentWork{
    String Username,Password;
    Scanner scanner = new Scanner(System.in);

    public Student() throws IOException {
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }


    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public void login() {
        int i = 0;
        boolean login = false;

        do {
            System.out.println("Enter Username");
            Username = scanner.next();
            System.out.println("Enter Password");
            Password = scanner.next();
            if (getUsername().equals("3") && getPassword().equals("3")) {
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

    @Override
    public void displayAttendance(String rollNo , String filePath2) {
        boolean found = false;

        try
        {
            x = new Scanner(new File(filePath2));
            x.useDelimiter(" |\n");
            String Roll = "";
            String Attendance = "";

            while(x.hasNextLine() && !found)
            {
                Roll = x.next();
                Attendance = x.next();
                if(Roll.equals(rollNo))
                {
                    found = true;
                }
            }
            if(found)
            {

                System.out.println(Roll);
                System.out.println(Attendance);
            }
            else
            {
                System.out.println("not found");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void displayMarks(String rollNo , String filePath3)
    {
        boolean found1 = false;


        try
        {
            y = new Scanner(new File(filePath3));
            y.useDelimiter(" |\n");
            String Roll = "";
            String Marks = "";
            while(y.hasNextLine() && !found1)
            {
                Roll = y.next();
                Marks = y.next();
                if(Roll.equals(rollNo))
                {
                    found1 = true;
                }
            }
            if(found1)
            {
                System.out.println(Roll);
                System.out.println(Marks);
            }
            else
            {
                System.out.println("Access denied");
            }

        }
        catch(Exception e){
            e.printStackTrace();

    }

    }


}
