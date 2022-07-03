package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class ClassroomTest {
    @Test
    public void getAverageExamScoreTest() {
        // : Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);
        Double expected = 125.0;

        // When
        Double output = classroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void addStudentTest() {
        // Given
        int maxNumberOfStudents = 1;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student("Leon", "Hunter", examScores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        Student[] postEnrollment = classroom.getStudents();

        // Then
        String preEnrollmentAsString = Arrays.toString(preEnrollment);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        Assert.assertNotEquals(preEnrollmentAsString, postEnrollmentAsString);
    }

    @Test
    public void removeStudentTest() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);

        Student[] students = {s1,s2};
        Classroom classroom = new Classroom(students);

        // When
        Student[] postEnrollment = classroom.getStudents();
        classroom.removeStudent("student", "two");
        Student[] postRemoval = classroom.getStudents();

        // Then
        String postRemovalAsString = Arrays.toString(postRemoval);
        String postEnrollmentAsString = Arrays.toString(postEnrollment);
        Assert.assertNotEquals(postRemovalAsString, postEnrollmentAsString);
    }

    @Test
    public void getStudentsByScoreTest() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 235.0 };
        Double[] s3Scores = { 100.0, 150.0 };
        Double[] s4Scores = { 25.0, 35.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "apple", s3Scores);
        Student s4 = new Student("bad", "four", s4Scores);

        Student[] students = {s1,s2,s3,s4};
        Classroom classroom = new Classroom(students);

        // When
        Student[] sortedClass = classroom.getStudentsByScore();

        // Then
        // TODO change sout to an assert
        System.out.println(Arrays.toString(sortedClass));
    }

    @Test
    public void getGradeBookTest() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 235.0 };
        Double[] s3Scores = { 100.0, 150.0 };
        Double[] s4Scores = { 25.0, 35.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "apple", s3Scores);
        Student s4 = new Student("bad", "four", s4Scores);

        Student[] students = {s1,s2,s3,s4};
        Classroom classroom = new Classroom(students);

        // When
        HashMap<Student, String> gradeBook = classroom.getGradeBook();

        // Then
        gradeBook.forEach((key, value) -> System.out.println(key.getLastName() + " " + value));
    }

    @Test
    public void getGradeByPercentileTest() {
        // Given
        Classroom classroom = new Classroom();
        Double percentile = 47.5;

        // When
        String actual = classroom.getGradeByPercentile(percentile);

        // Then
        Assert.assertEquals("D", actual);
    }
}
