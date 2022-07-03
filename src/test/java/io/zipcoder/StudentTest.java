package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {
    @Test
    public void getExamScoresTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 95.0, 123.0, 96.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        String output = student.getExamScores();
        String expected = "Exam Scores:\n" +
                "        Exam 1 -> 100\n" +
                "        Exam 2 -> 95\n" +
                "        Exam 3 -> 123\n" +
                "        Exam 4 -> 96";

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void addExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.addExamScore(100.0);
        String output = student.getExamScores();
        int numScores = student.getNumberOfExamsTaken();

        // Then
        Assert.assertEquals(1, numScores);
    }

    @Test
    public void setExamScores() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0 };
        Student student = new Student(firstName, lastName, examScores);

        // When
        student.setExamScores(1, 150.0);
        String output = student.getExamScores();

        // Then
        //Assert.assertEquals(expected, output);
    }
}