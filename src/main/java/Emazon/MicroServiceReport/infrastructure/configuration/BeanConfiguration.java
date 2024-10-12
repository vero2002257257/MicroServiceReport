package Emazon.MicroServiceReport.infrastructure.configuration;
import Emazon.MicroServiceReport.domain.api.IReportServicePort;
import Emazon.MicroServiceReport.domain.spi.IReportPersistencePort;
import Emazon.MicroServiceReport.domain.usecase.ReportUseCase;
import Emazon.MicroServiceReport.infrastructure.jpa.adapter.ReportJpaAdapter;
import Emazon.MicroServiceReport.infrastructure.jpa.mapper.ReportEntityMapper;
import Emazon.MicroServiceReport.infrastructure.jpa.repository.IReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IReportRepository reportRepository;
    private final ReportEntityMapper reportEntityMapper;

    @Bean
    public IReportPersistencePort reportPersistencePort() {
        return new ReportJpaAdapter(reportRepository, reportEntityMapper);
    }

    @Bean
    public IReportServicePort reportServicePort() {
        return new ReportUseCase(reportPersistencePort());
    }
}
