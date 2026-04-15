package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeReportServiceTest {

    @Test
    void averageReportFormatsStudentNameAndAverage() {
        GradeReportService service = new GradeReportService();
        assertEquals("Alice Johnson average: 90.00", service.buildAverageReport("  alice   JOHNSON ", 95, 90, 85));
    }

    @Test
    void improvementReportUsesSubtractionAndTitleCase() {
        GradeReportService service = new GradeReportService();
        assertEquals("Midterm Score improvement: 18", service.buildImprovementReport("  midterm score ", 72, 90));
    }

    @Test
    void passingStatusUsesAverageThreshold() {
        GradeReportService service = new GradeReportService();
        assertTrue(service.isPassing(70, 68, 72, 80));
        assertFalse(service.isPassing(85, 70, 82, 84));
    }

    @Test
    void keywordSearchNormalizesWhitespace() {
        GradeReportService service = new GradeReportService();
        assertTrue(service.hasKeyword("  honors   progress   report ", "progress"));
        assertFalse(service.hasKeyword("weekly update", "final"));
    }
}
