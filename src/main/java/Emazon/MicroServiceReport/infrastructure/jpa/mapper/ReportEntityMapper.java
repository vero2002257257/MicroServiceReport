package Emazon.MicroServiceReport.infrastructure.jpa.mapper;

import Emazon.MicroServiceReport.domain.models.Report;
import Emazon.MicroServiceReport.infrastructure.jpa.entity.ReportEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReportEntityMapper {
    @Mapping(target = "email", source = "report.userEmail")
    @Mapping(target = "purchaseDate", source = "report.purchaseDate")
    @Mapping(target = "totalAmount", source = "report.totalAmount")
    @Mapping(target = "items", source = "report.items")
    ReportEntity toEntity(Report report);

}
