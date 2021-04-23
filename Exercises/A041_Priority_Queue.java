package Exercises;

/*
Sample Input 0
12
ENTER John 3.75 50          John is added to Q. So, it contains (John, 3.75, 50).
ENTER Mark 3.8 24           Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).
ENTER Shafaet 3.7 35        Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).
SERVED                      Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).
SERVED                      John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
ENTER Samiha 3.85 36        Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).
SERVED                      Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50           four more students are added to Q. So, it contains 
                            (Shafaet, 3.7, 35), (Ashley, 3.9, 42), (Maria, 3.6, 46), (Anik, 3.95, 49), and (Dan, 3.95, 50).
SERVED                      Anik is served because though both Anik and Dan have the highest CGPA but Anik comes first when sorted in alphabetic order. 
                            So, Q contains (Dan, 3.95, 50), (Ashley, 3.9, 42), (Shafaet, 3.7, 35), and (Maria, 3.6, 46).

Sample Output 0
Dan
Ashley
Shafaet
Maria
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student1 implements Comparable<Student1>{
    private int id;
    private String name;
    private double cgpa;

    Student1(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName(){
        return this.name;
    }

    public int getId() {
        return id;
    }
    
    public double getCgpa() {
        return cgpa;
    }

    @Override
    public int compareTo(Student1 u) {
        if (Double.compare(u.getCgpa(),getCgpa()) != 0){
            return Double.compare(u.getCgpa(),getCgpa());
        }
        return getName().compareTo(u.getName());
    }
}

class Priorities {
    List<Student1> students = new ArrayList<>();

    public List<Student1> getStudents(List<String> events){

        for (String event : events) {
            if (event.contains("ENTER")){
                insertStudent(event);
            }else{
                removeStudent();
            }
        }

        java.util.Collections.sort(students);

        return students;
    }

    public void removeStudent(){
        Student1 max = null;

        for (Student1 student1 : students) {
            if (max == null){
                max = student1;
                continue;
            }

            if (student1.getCgpa() >= max.getCgpa()){                       // If max or equal to previous max
                if (student1.getCgpa() == max.getCgpa()){                   // If equal
                    if (max.getName().compareTo(student1.getName()) > 0){   // If new_name before max_name
                        max = student1;
                    }
                } 
                else        // If max
                {
                    max = student1;
                }            
            }
        }

        for (int i = 0; i< students.size() ; i++) {
            if(students.get(i).getId() == max.getId()){
                students.remove(i);
            }
        }

    }

    public void insertStudent(String event){
        String[] info = event.split(" ");
        students.add(new Student1(Integer.parseInt(info[3]), info[1], Double.parseDouble(info[2])));
    }
}

public class A041_Priority_Queue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student1> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student1 st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

