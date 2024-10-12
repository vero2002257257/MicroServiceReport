package Emazon.MicroServiceReport.application.mapper;
import Emazon.MicroServiceReport.application.dto.ReportRequest;
import Emazon.MicroServiceReport.domain.models.Report;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportRequestMapper {

    @Mapping(target = "items", source = "reportRequest.items")
    @Mapping(target = "totalAmount", source = "reportRequest.totalAmount")
    @Mapping(target = "userEmail", source = "reportRequest.userEmail")
    @Mapping(target = "purchaseDate", source = "reportRequest.purchaseDate")
    Report toReport(ReportRequest reportRequest);

}