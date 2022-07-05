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
    public void getAverageExamScoreTest2() {
        // : Given
        Double[] s1Scores = { 100.0, 100.0 };
        Double[] s2Scores = { 85.0, 95.0 };
        Double[] s3Scores = { 42.0, 47.0 };
        Double[] s4Scores = { 85.0, 65.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "three", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);
        Double expected = 77.375;

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
    public void addStudentTest2() {
        // Given
        int maxNumberOfStudents = 15;
        Classroom classroom = new Classroom(maxNumberOfStudents);
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Double[] s2Scores = { 70.0, 70.0, 60.0, 70.0 };
        Student student = new Student("Leon", "Hunter", examScores);
        Student s2 = new Student("Student", "Two", s2Scores);

        // When
        Student[] preEnrollment = classroom.getStudents();
        classroom.addStudent(student);
        classroom.addStudent(s2);
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
    public void removeStudentTest2() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 25.0 };
        Double[] s3Scores = { 42.0, 47.0 };
        Double[] s4Scores = { 85.0, 65.0 };

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "thr", s3Scores);
        Student s4 = new Student("student", "four", s4Scores);

        Student[] students = {s1, s2, s3, s4};
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

        Student[] expected = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(expected);

        // When
        Student[] postSort = classroom.getStudentsByScore();

        // Then
        String postSortAsString = Arrays.toString(postSort);
        String postEnrollmentAsString = Arrays.toString(expected);
        Assert.assertNotEquals(postSortAsString, postEnrollmentAsString);
    }

    @Test
    public void getStudentsByScoreTest2() {
        // Given
        Double[] s1Scores = { 100.0, 150.0 };
        Double[] s2Scores = { 225.0, 235.0 };
        Double[] s3Scores = { 100.0, 150.0 };
        Double[] s4Scores = { 25.0, 35.0 };
        Double[] s5Scores = {66.0, 90.0};

        Student s1 = new Student("student", "one", s1Scores);
        Student s2 = new Student("student", "two", s2Scores);
        Student s3 = new Student("student", "apple", s3Scores);
        Student s4 = new Student("bad", "four", s4Scores);
        Student s5 = new Student("benzo", "tony", s5Scores);

        Student[] students = {s1, s2, s3, s4};
        Classroom classroom = new Classroom(students);

        // When
        Student[] postSort = classroom.getStudentsByScore();
        classroom.addStudent(s5);
        Student[] postAddition = classroom.getStudentsByScore();

        // Then
        String postSortAsString = Arrays.toString(postSort);
        String postAdditionAsString = Arrays.toString(postAddition);
        Assert.assertNotEquals(postSortAsString, postAdditionAsString);
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

    @Test
    public void getGradeByPercentileTest2() {
        // Given
        Classroom classroom = new Classroom();
        Double percentile = 90.0;

        // When
        String actual = classroom.getGradeByPercentile(percentile);

        // Then
        Assert.assertEquals("A", actual);
    }
}
