package Emazon.MicroServiceReport.application.handler;


import Emazon.MicroServiceReport.application.dto.ReportRequest;

public interface IReportHandler {
    void createReport(ReportRequest reportRequest);
}