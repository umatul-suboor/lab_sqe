package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class GradebookTest {
    Gradebook gradebook = new Gradebook();
    // ---------- EP (Lab 5) ----------
    @ParameterizedTest(name = "EP letterGrade {0} -> {1}")
    @CsvSource({"45,F","65,D","75,C","85,B","95,A"})
    void epLetterGrade(int s, String exp) { assertEquals(exp, gradebook.letterGrade(s)); }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1, 101, 150})
    void epLetterGradeInvalid(int s) {
        assertThrows(IllegalArgumentException.class, () -> gradebook.letterGrade(s));
    }

    // ---------- BVA (Lab 6) ----------
    @ParameterizedTest(name = "BVA letterGrade {0} -> {1}")
    @CsvSource({
        "0,F","1,F","59,F","60,D","61,D","69,D","70,C","71,C",
        "79,C","80,B","81,B","89,B","90,A","91,A","99,A","100,A"
    })
    void bvaLetterGrade(int s, String exp) { assertEquals(exp, gradebook.letterGrade(s)); }

    @ParameterizedTest(name = "BVA count {0} -> {1}")
    @CsvSource({"1,1","2,2","5,5","6,6"})
    void bvaScoreCount(int n, int exp) { assertEquals(exp, gradebook.scoreCount(n)); }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 7})
    void bvaScoreCountInvalid(int n) {
        assertThrows(IllegalArgumentException.class, () -> gradebook.scoreCount(n));
    }

    // ---------- AAA + fixture (Lab 7) ----------
    @Test
    void averageEmptyReturnsZero() {
        // Act
        double r = Gradebook.average(new int[]{});
        // Assert
        assertEquals(0.0, r, 1e-9);
    }

    @Test
    void averageMultiple() {
        assertEquals(85.0, gradebook.average(new int[]{80, 90}), 1e-9);
    }

    
    @Test
    void validateNameEmptyReturnsTrue() {
        assertTrue(Gradebook.validateName(""));
    }

    @Test
    void validateName50CharsValid() {
        String name = String.join("", java.util.Collections.nCopies(50, "a"));
        assertEquals(50, name.length());
        assertTrue(Gradebook.validateName(name));
    }
    
    @Test
    void validateName51CharsInvalid() {
        String name = String.join("", java.util.Collections.nCopies(51, "a"));
        assertFalse(Gradebook.validateName(name));
    }

}