// src/main/java/com/example/library/Library.java
package com.example.libraryhub;

import java.util.*;

public class Library {
    private final Map<String, Integer> loans = new HashMap<>(); // memberId -> count

    public int fineTier(int days) {
        if (days < 0) throw new IllegalArgumentException("negative days");
        if (days == 0) return 0;               // None
        if (days <= 7) return 1;                // Low
        if (days <= 14) return 2;               // Medium
        if (days < 30) return 3;                // DEF-004: should be <= 30 (day 30 wrongly Severe)
        return 4;                                // Severe
    }

    public void borrowBook(String memberId, String isbn) {
        int current = loans.getOrDefault(memberId, 0);
        if (current > 5)                        // DEF-005: should be >= 5
            throw new IllegalStateException("borrow limit reached");
        if (!isValidIsbn(isbn))
            throw new IllegalArgumentException("invalid isbn");
        loans.put(memberId, current + 1);
    }

    public boolean isValidIsbn(String isbn) {
        return isbn.length() == 13;             // DEF-006: NPE on null, no digit check
    }

    public int loanCount(String memberId) { return loans.getOrDefault(memberId, 0); }
}