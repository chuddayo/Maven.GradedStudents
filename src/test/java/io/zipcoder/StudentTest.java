package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

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
        String expected = "Exam Scores:" +
                "\n\tExam 1 -> 100" +
                "\n\tExam 2 -> 95" +
                "\n\tExam 3 -> 123" +
                "\n\tExam 4 -> 96";

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

        String expected = "Exam Scores:\n" +
                "\tExam 1 -> 150";

        // When
        student.setExamScores(1, 150.0);
        String output = student.getExamScores();


        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void getAverageExamScoreTest() {
        // Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        Double expected = 125.0;

        // When
        Double output = student.getAverageExamScore();

        // Then
        Assert.assertEquals(expected, output);
    }

    @Test
    public void toStringTest() {
        // : Given
        String firstName = "Leon";
        String lastName = "Hunter";
        Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
        Student student = new Student(firstName, lastName, examScores);
        String expected = "Student Name: Leon Hunter\n" +
                "> Average Score: 125\n" +
                "> Exam Scores:\n" +
                "\tExam 1 -> 100\n" +
                "\tExam 2 -> 150\n" +
                "\tExam 3 -> 250\n" +
                "\tExam 4 -> 0";

        // When
        String output = student.toString();

        // Then
        Assert.assertEquals(expected, output);
    }
}