package com.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class GradeReportServiceTest {

    @Test
    public void averageReportFormatsStudentNameAndAverage() {
        GradeReportService service = new GradeReportService();
        assertEquals("Alice Johnson average: 90.00", service.buildAverageReport("  alice   JOHNSON ", 95, 90, 85));
    }

    @Test
    public void improvementReportUsesSubtractionAndTitleCase() {
        GradeReportService service = new GradeReportService();
        assertEquals("Midterm Score improvement: 18", service.buildImprovementReport("  midterm score ", 72, 90));
    }

    @Test
    public void passingStatusUsesAverageThreshold() {
        GradeReportService service = new GradeReportService();
        assertTrue(service.isPassing(70, 68, 72, 80));
        assertFalse(service.isPassing(85, 70, 82, 84));
    }

    @Test
    public void keywordSearchNormalizesWhitespace() {
        GradeReportService service = new GradeReportService();
        assertTrue(service.hasKeyword("  honors   progress   report ", "progress"));
        assertFalse(service.hasKeyword("weekly update", "final"));
    }
}
