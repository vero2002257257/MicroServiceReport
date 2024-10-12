package Emazon.MicroServiceReport.infrastructure.jpa.adapter;

import Emazon.MicroServiceReport.domain.models.Report;
import Emazon.MicroServiceReport.domain.spi.IReportPersistencePort;
import Emazon.MicroServiceReport.infrastructure.jpa.entity.ReportEntity;
import Emazon.MicroServiceReport.infrastructure.jpa.mapper.ReportEntityMapper;
import Emazon.MicroServiceReport.infrastructure.jpa.repository.IReportRepository;
import lombok.RequiredArgsConstructor;

import java.time.ZoneId;
import java.util.Date;

@RequiredArgsConstructor
public class ReportJpaAdapter implements IReportPersistencePort {

    private final IReportRepository reportRepository;
    private final ReportEntityMapper reportEntityMapper;


    @Override
    public void saveReport(Report report) {
        ReportEntity reportEntity = reportEntityMapper.toEntity(report);
        Date out = Date.from(report.getPurchaseDate().atZone(ZoneId.systemDefault()).toInstant());
        reportEntity.setPurchaseDate(out);
        reportRepository.save(reportEntity);

    }
}
