package com.company;
import java.io.*;
import java.util.*;
interface AdminWork
{
    void login() throws Exception;
    void AddStudent() throws IOException;
    void DeleteStudent(String filepath,String roll);
    void ModifyStudent(String editTerm,String name,String age,String rollno,String Class,String filepath);
    void AddTeacher() throws IOException;
    void DeleteTeacher(String filepath1,String tname);
    void ModifyTeacher(String editTerm1,String name1,String age1,String salary,String quali,String filepath1);

}
public class Admin extends Main implements AdminWork {

    String Username;
    String Password;
    String StudentName,TeacherName;
    String StudentClass;
    String StudentAge,TeacherAge;
    String StudentRollNo;
    String Qualification;
    int TeacherSalary;


    public Admin() throws IOException {
    }

    public Admin(String studentName, String studentClass, String studentAge, String studentRollNo) throws IOException {
        StudentName = studentName;
        StudentClass = studentClass;
        StudentAge = studentAge;
        StudentRollNo = studentRollNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public String getStudentAge() {
        return StudentAge;
    }

    public String getStudentRollNo() {
        return StudentRollNo;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public void setStudentAge(String studentAge) {
        StudentAge = studentAge;
    }

    public void setStudentRollNo(String studentRollNo) {
        StudentRollNo = studentRollNo;
    }

    public String toString() {
        return StudentName + " " + StudentClass + " " + StudentAge + " " + StudentRollNo;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void login() throws Exception {
        boolean login = false;
        Scanner scanner = new Scanner(System.in);
        int attempts= 0;
        do {
            System.out.println("Enter Username");
            Username = scanner.next();
            System.out.println("Enter Password");
            Password = scanner.next();

            if (getUsername().equals("1") && getPassword().equals("1"))
            {
                System.out.println("Login Successful");
                login = true;
                break;
            }
            else {
                System.out.println("Try Again!");
            }
            attempts++;

        } while (attempts< 3) ;
        if (attempts==3)
        {
            System.out.println("YOU HAVE ENTERED PASSWORD OR USERNAME WRONG TOO MANY TIMES");
            System.exit(0);
        }

    }

    @Override
    public void AddStudent() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = null;
        try {
            file = new File("StudentData.txt");
            if (file.createNewFile()) {
                System.out.println("file created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        PrintWriter pw = new PrintWriter(bw);
        System.out.println("Enter The Number Of Students You Want To Add");
        int number = scanner.nextByte();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Student Name");
            StudentName = scanner.next();
            System.out.println("Enter Student Class");
            StudentClass = scanner.next();
            System.out.println("Enter Student Age");
            StudentAge = scanner.next();
            System.out.println("Enter Student Roll No");
            StudentRollNo = scanner.next();
            pw.print(StudentRollNo + " " + StudentName + " " + StudentAge + " " + StudentClass+"\n");
        }
        pw.close();

    }

    @Override
    public void DeleteStudent(String filepath,String rollno) {
        String TempFile = "Temp.txt";
        File OldFile = new File(filepath);
        File NewFile = new File(TempFile);
        String Name = "";
        String Age = "";
        String RollNo = "";
        String Clas = "";
        try {
            FileWriter fw = new FileWriter(TempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter(" |\n");
            while (x.hasNext()) {
                RollNo = x.next();
                Name = x.next();
                Age = x.next();
                Clas = x.next();
                if (!RollNo.equals(rollno))
                {
                    pw.print(RollNo +Name +" " + Name + " " + Age + " " + "\n");
                }
            }
            x.close();
            pw.close();
            pw.flush();
            OldFile.delete();
            File dump =new File(filepath);
            NewFile.renameTo(dump);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void ModifyStudent(String editTerm,String name,String age,String rollno, String Class ,String filepath) {
        String TempFile = "Temp.txt";
        File OldFile =  new File(filepath);
        File NewFile = new File(TempFile);
        String Name = ""; String Age = ""; String RollNo = "";String Clas = "";
        try {
            FileWriter fw = new FileWriter(TempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw  = new PrintWriter (bw);
            x = new Scanner(new File(filepath));
            x.useDelimiter(" |\n");
            while (x.hasNext())
            {
                RollNo = x.next();
                Name = x.next();
                Age = x.next();
                Clas = x.next();
                if (RollNo .equals(editTerm))
                {
                    pw.print(rollno + " " + name + " " + age + " " + Class+"\n");
                }
                else
                    pw.print(RollNo + " " + Name + " " + Age + " " + Clas+"\n");
            }
            x.close();
            pw.close();
            pw.flush();
            OldFile.delete();
            File dump =new File(filepath);
            NewFile.renameTo(dump);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void AddTeacher() throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = null;
        try {
            file = new File("TeacherData.txt");
            if (file.createNewFile()) {
                System.out.println("file created");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        PrintWriter pw = new PrintWriter(bw);
        System.out.println("Enter The Number Of Teachers You Want To Add");
        int number = scanner.nextByte();
        for (int i = 0; i < number; i++) {
            System.out.println("Enter Teacher Name");
            TeacherName = scanner.next();
            System.out.println("Enter Teacher Classification");
            Qualification = scanner.next();
            System.out.println("Enter Teacher Age");
            TeacherAge = scanner.next();
            System.out.println("Enter Teacher Salary");
            TeacherSalary = scanner.nextInt();
            pw.print(TeacherName + " " + Qualification + " " + TeacherAge + " " + TeacherSalary+"\n");
        }
        pw.close();

    }

    @Override
    public void DeleteTeacher(String filepath1, String tname) {
        String TempFile1 = "Temp1.txt";
        File OldFile = new File(filepath1);
        File NewFile = new File(TempFile1);
        String TName = "";
        String TQuali = "";
        String TAge = "";
        String TSalary = "";
        try {
            FileWriter fw = new FileWriter(TempFile1, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            x = new Scanner(new File(filepath1));
            x.useDelimiter(" |\n");
            while (x.hasNext()) {
                TName = x.next();
                TQuali = x.next();
                TAge = x.next();
                TSalary = x.next();
                if (!TName.equals(tname))
                {
                    pw.print(TName +TQuali +" " + TAge + " " + TSalary + " " + "\n");
                }
            }
            x.close();
            pw.close();
            pw.flush();
            OldFile.delete();
            File dump1 =new File(filepath1);
            NewFile.renameTo(dump1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void ModifyTeacher(String editTerm1, String name1, String age1, String salary, String quali, String filepath1) {
        String TempFile1= "Temp1.txt";
        File OldFile =  new File(filepath1);
        File NewFile = new File(TempFile1);
        String TName = ""; String TQuali = ""; String TAge = "";String TSalary = "";
        try {
            FileWriter fw = new FileWriter(TempFile1,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw  = new PrintWriter (bw);
            x = new Scanner(new File(filepath1));
            x.useDelimiter(" |\n");
            while (x.hasNext())
            {
                TName = x.next();
                TQuali = x.next();
                TAge = x.next();
                TSalary = x.next();
                if (TName.equals(editTerm1))
                {
                    pw.print( name1 + " " + quali + " " + age1 + " " + salary+"\n");
                }
                else
                    pw.print(TName+ " " + TQuali + " " + TAge + " " + TSalary+"\n");
            }
            x.close();
            pw.close();
            pw.flush();
            OldFile.delete();
            File dump1 =new File(filepath1);
            NewFile.renameTo(dump1);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}