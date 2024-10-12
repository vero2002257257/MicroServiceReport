package Emazon.MicroServiceReport.infrastructure.jpa.repository;

import Emazon.MicroServiceReport.infrastructure.jpa.entity.ReportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends MongoRepository<ReportEntity, String> {
}