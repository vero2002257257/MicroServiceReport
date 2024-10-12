package Emazon.MicroServiceReport.domain.usecase;

import Emazon.MicroServiceReport.domain.models.Report;
import Emazon.MicroServiceReport.domain.spi.IReportPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ReportUseCaseTest {

    @Mock
    private IReportPersistencePort reportPersistencePort;

    @InjectMocks
    private ReportUseCase reportUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createReport_ShouldSetPurchaseDateAndSaveReport() {
        // Arrange
        Report report = new Report();
        report.setId(String.valueOf(1L));
        report.setProductId(2L);
        report.setQuantity(3);

        // Mock para simular el comportamiento del puerto de persistencia
        doNothing().when(reportPersistencePort).saveReport(report);

        // Act
        reportUseCase.createReport(report);

        // Assert
        assertNotNull(report.getPurchaseDate(), "La fecha de compra debe ser establecida");
        assertTrue(report.getPurchaseDate().isBefore(LocalDateTime.now().plusSeconds(1)),
                "La fecha de compra debe ser la fecha actual");

        verify(reportPersistencePort, times(1)).saveReport(report); // Verificar que se llame al método de persistencia
    }
}
