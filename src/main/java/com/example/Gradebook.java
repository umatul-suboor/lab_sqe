package com.example;
// src/main/java/com/example/gradebook/GradeBook.java
public class Gradebook {

    public static String letterGrade(int score) {
        if (score < 0 || score > 100)
            throw new IllegalArgumentException("score out of range");
        if (score >= 90) return "A";          // DEF-001: should be >= 90
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public static int scoreCount(int n) {
        if (n < 1 || n > 6)
            throw new IllegalArgumentException("1-6 scores required");
        return n;
    }

    public static double average(int[] scores) {
        int sum = 0;
        for (int s : scores) sum += s;
        return sum / scores.length;          // DEF-002: no empty guard
    }

    public static boolean validateName(String name) {
        return name.length() <= 50;          // DEF-003: no null/empty guard
    }
}