package Emazon.MicroServiceReport.domain.usecase;

import Emazon.MicroServiceReport.domain.api.IReportServicePort;
import Emazon.MicroServiceReport.domain.models.Report;
import Emazon.MicroServiceReport.domain.spi.IReportPersistencePort;

import java.time.LocalDateTime;

public class ReportUseCase implements IReportServicePort {

    private final IReportPersistencePort reportPersistencePort;

    public ReportUseCase(IReportPersistencePort reportPersistencePort) {
        this.reportPersistencePort = reportPersistencePort;
    }


    @Override
    public void createReport(Report report) {
        report.setPurchaseDate(LocalDateTime.now());
        reportPersistencePort.saveReport(report);
    }
}
