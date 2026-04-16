# 417_final_project

This project is a small regression test selection demo built around Ekstazi.

The demo uses JUnit 4-style test classes because that is the class-based execution path Ekstazi 5.3.0 supports in this setup.

The test suite is intentionally split across isolated and shared dependencies so RTS is easy to observe:

- `CalculatorTest` only exercises `Calculator`
- `StringUtilsTest` only exercises `StringUtils`
- `GradeReportServiceTest` exercises `GradeReportService`, which depends on both `Calculator` and `StringUtils`

That gives you useful report scenarios:

- changing `Calculator` should affect `CalculatorTest` and `GradeReportServiceTest`
- changing `StringUtils` should affect `StringUtilsTest` and `GradeReportServiceTest`
- changing `GradeReportService` should primarily affect `GradeReportServiceTest`
