package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Classroom {
    public Student[] students;
    public Classroom() {
        this.students = new Student[30];
    }
    public Classroom(Student[] students) {
        this.students = students;
    }
    public Classroom(int maxNumberOfStudents) {
        this.students = new Student[maxNumberOfStudents];
    }
    public Double getAverageExamScore() {
        Double sum = 0.0;
        for (Student student: students) {
            sum += student.getAverageExamScore();
        }
        return sum / students.length;
    }
    public void addStudent(Student student) {
        ArrayList<Student> newStudentList = new ArrayList<>(Arrays.asList(students));
        newStudentList.add(student);
        students = newStudentList.toArray(new Student[newStudentList.size()]);
    }
    public void removeStudent(String firstName, String lastName) {
        // removal without leaving null values
        ArrayList<Student> newStudentList = new ArrayList<>(Arrays.asList(students));
        for (int i = 0; i < newStudentList.size(); i++) {
            if (newStudentList.get(i).getFirstName().equals(firstName) &&
                newStudentList.get(i).getLastName().equals(lastName)) {
                newStudentList.remove(newStudentList.get(i));
                i--;
            }
        }
        students = newStudentList.toArray(new Student[newStudentList.size()]);
    }
    public Student[] getStudents() {
        return students;
    }

}
