package io.zipcoder;

import java.util.*;

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
        students = newStudentList.toArray(new Student[0]);
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
        students = newStudentList.toArray(new Student[0]);
    }
    public Student[] getStudentsByScore() {
        ArrayList<Student> newStudentList = new ArrayList<>(Arrays.asList(students));

        Comparator<Student> byExamScore = Comparator.comparing(Student::getAverageExamScore);
        Comparator<Student> byLastName = Comparator.comparing(Student::getLastName);
        newStudentList.sort(byExamScore.reversed().thenComparing(byLastName));

        return newStudentList.toArray(new Student[0]);
    }
    public Student[] getStudents() {
        return students;
    }

}
