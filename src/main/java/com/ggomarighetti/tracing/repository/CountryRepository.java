package com.ggomarighetti.tracing.repository;

import com.ggomarighetti.tracing.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<CountryEntity, String> {

    Optional<CountryEntity> findByName(String name);

    Optional<CountryEntity> findByCode(String code);
}
