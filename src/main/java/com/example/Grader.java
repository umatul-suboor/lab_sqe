package com.example;
public class Grader{
public char determineGrade(int marks){
    if(marks < 0){
        throw new IllegalArgumentException("Marks cannot be negative");
    } else if(marks >= 90){
        return 'A';
    } else if(marks >= 80){
        return 'B';
    } else if(marks >= 70){
        return 'C';
    } else if(marks >= 60){
        return 'D';
    } else {
        return 'F';
       
    }

}
}