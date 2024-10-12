package Emazon.MicroServiceReport.domain.api;

import Emazon.MicroServiceReport.domain.models.Report;

public interface IReportServicePort {
    void createReport(Report report);
}