package com.example;

import java.util.Locale;

public class GradeReportService {
    private final Calculator calculator;
    private final StringUtils stringUtils;

    public GradeReportService() {
        this(new Calculator(), new StringUtils());
    }

    public GradeReportService(Calculator calculator, StringUtils stringUtils) {
        this.calculator = calculator;
        this.stringUtils = stringUtils;
    }

    public String buildAverageReport(String studentName, int... scores) {
        String formattedName = stringUtils.toTitleCase(studentName);
        double average = calculator.average(scores);
        return String.format(Locale.US, "%s average: %.2f", formattedName, average);
    }

    public String buildImprovementReport(String category, int startingScore, int endingScore) {
        String formattedCategory = stringUtils.toTitleCase(category);
        int improvement = calculator.subtract(endingScore, startingScore);
        return String.format(Locale.US, "%s improvement: %d", formattedCategory, improvement);
    }

    public boolean isPassing(int passingScore, int... scores) {
        return calculator.average(scores) >= passingScore;
    }

    public boolean hasKeyword(String reportTitle, String keyword) {
        if (stringUtils.isBlank(keyword)) {
            return false;
        }

        String normalizedTitle = stringUtils.normalizeWhitespace(reportTitle);
        return normalizedTitle != null
                && normalizedTitle.toLowerCase(Locale.ROOT)
                .contains(keyword.trim().toLowerCase(Locale.ROOT));
    }
}
