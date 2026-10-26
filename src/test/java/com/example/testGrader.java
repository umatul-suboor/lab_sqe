package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class testGrader {
    @Test
    void fiftynineShouldReturnF(){
        var grader = new Grader();
        assertEquals('F',grader.determineGrade(59));
    }

    @Test
    void sixtyNineShouldReturnD(){
        var grader = new Grader();
        assertEquals('D', grader.determineGrade(69));
    }

   

    @Test 
    void negativeMarksShouldThrowException(){
        var grader = new Grader();
        assertThrows(IllegalArgumentException.class, () -> {
            grader.determineGrade(-1);
        });
    }


}
