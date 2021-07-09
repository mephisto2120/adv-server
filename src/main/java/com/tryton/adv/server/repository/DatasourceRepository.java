package com.tryton.adv.server.repository;

import com.tryton.adv.server.entity.DatasourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DatasourceRepository extends JpaRepository<DatasourceEntity, Long> {
    Optional<DatasourceEntity> findByName(String name);
}
