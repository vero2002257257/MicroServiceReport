package Emazon.MicroServiceReport.domain.spi;

import Emazon.MicroServiceReport.domain.models.Report;

public interface IReportPersistencePort {
    void saveReport(Report report);
}