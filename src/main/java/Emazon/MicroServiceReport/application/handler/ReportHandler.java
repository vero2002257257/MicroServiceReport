package Emazon.MicroServiceReport.application.handler;

import Emazon.MicroServiceReport.application.dto.ReportRequest;
import Emazon.MicroServiceReport.application.mapper.ReportRequestMapper;
import Emazon.MicroServiceReport.domain.api.IReportServicePort;
import Emazon.MicroServiceReport.domain.models.Report;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class ReportHandler implements IReportHandler {

    private final IReportServicePort reportServicePort;
    private final ReportRequestMapper reportRequestMapper;

    @Override
    public void createReport(ReportRequest reportRequest) {
        Report report = reportRequestMapper.toReport(reportRequest);
        reportServicePort.createReport(report);
    }
}
