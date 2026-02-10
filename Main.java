package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // ------------- starting of student storing system-------------
    ArrayList<StudentManagement> students = new ArrayList<>();
        Scanner user_input = new Scanner(System.in);


        try{
            BufferedReader read = new BufferedReader(new FileReader("students.txt"));
            String line;
            while((line = read.readLine()) != null ){
                String [] student_data = line.split(",");
                int studentId =Integer.parseInt(student_data[0]);
                String name = student_data[1];
                int age = Integer.parseInt(student_data[2]);
                int score = Integer.parseInt(student_data[3]);
                students.add(new StudentManagement(studentId,name,age,score));
            }

            System.out.println("-------- Students we have ------------");
            for(StudentManagement s : students){
                System.out.println(s.studentId + " " + s.name + " " + s.age + " " + s.score
                );
            }
            System.out.println("\n");
            System.out.println("\n");

            double total = 0;
            StudentManagement student_high_score = students.get(0);
            StudentManagement student_low_score = students.get(0);

            ArrayList<StudentManagement> success = new ArrayList<>();
            ArrayList<StudentManagement> fail = new ArrayList<>();

            for(int i=0; i<students.size(); i++){
                StudentManagement s =students.get(i);
                if (student_high_score.score < s.score ){
                    student_high_score = students.get(i);
                }
                if (student_low_score.score > s.score){
                    student_low_score = students.get(i);
                }
                if(s.score < 60 ){
                    success.add(s);
                }else{
                    fail.add(s);
                }
                total += s.score;

            }

            double average = total/students.size();

            System.out.println("-----------Students Success------------");
            for(StudentManagement su : success){
                System.out.println(su.name);
            }

            System.out.println("-----------Students Fail------------");
            for(StudentManagement fa : fail){
                System.out.println(fa.name);
            }


            System.out.println("--------Performance in Class------------------");
            System.out.println(" Students who has highest marks is:" + " " + student_high_score.name + " " + "he has marks" + " "+ student_high_score.score);
            System.out.println(" Students who has lowest marks is:" + " " + student_low_score.name + " " +  "he has marks" + " "+ student_low_score.score);
            System.out.println("Average is:" + " " + average);
            System.out.println("\n");
            System.out.println("\n");

            System.out.println("-----------press 1 if you want to Add new Student--------------");
            System.out.println("enter number :");
            int  choice = user_input.nextInt();
            if (choice == 1){
                System.out.println("Enter student ID:");
                int studentId = user_input.nextInt();
                user_input.nextLine();

                System.out.println("Enter student name:");
                String name = user_input.nextLine();

                System.out.println("Enter age:");
                int age = user_input.nextInt();

                System.out.println("Enter marks:");
                double marks = user_input.nextDouble();

                students.add(new StudentManagement(studentId,name,age,marks));
                System.out.println("Student added Successful");
            }
            else {
                System.out.println("Invalid Input");
            }

            System.out.println("-----------press 2 if you want to update student score of any student--------------");

            int choice2 = user_input.nextInt();
            if (choice2 == 2){
                System.out.println("Enter student_id");
                int studentId = user_input.nextInt();

                System.out.println("Enter student new marks");
                double new_student_marks = user_input.nextDouble();

                for(int i =0 ; i< students.size(); i++){
                    StudentManagement ad = students.get(i);
                    if(ad.studentId == studentId){
                        // ad.score = new_student_marks;
                        students.get(i).score = new_student_marks;
                        System.out.println("Score Updated successfully");
                        break;
                    }else {
                        System.out.println("Invalid input");
                    }
                }

                    try{
                        BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));

                        for(StudentManagement s : students) {
                            writer.write(s.studentId + "," + s.name + "," + s.age + "," + s.score);
                        }
                    }catch(Exception e){
                        System.out.println("write on file failed");
                        }
            }
        }catch (Exception e) {
            System.out.println("failed to read file");

        }
    }
}
// -------------------------------------------------- ending of student storing system----------------------------------------------------------------------------
