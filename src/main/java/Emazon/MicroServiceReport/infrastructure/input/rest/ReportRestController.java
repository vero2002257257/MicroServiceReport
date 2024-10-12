package Emazon.MicroServiceReport.infrastructure.input.rest;

import Emazon.MicroServiceReport.application.dto.ReportRequest;
import Emazon.MicroServiceReport.application.handler.IReportHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportRestController {

    private final IReportHandler reportHandler;

    @Operation(summary = "Crear un nuevo reporte de compra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reporte creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Petición inválida"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    @PostMapping("/create")
    public ResponseEntity<Void> createReport(@Valid @RequestBody ReportRequest reportRequest) {
        reportHandler.createReport(reportRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}