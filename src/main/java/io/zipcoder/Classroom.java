package io.zipcoder;

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
    public Student[] getStudents() {
        return students;
    }

}
