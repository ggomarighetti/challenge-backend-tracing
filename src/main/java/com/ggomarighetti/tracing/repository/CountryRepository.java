package com.ggomarighetti.tracing.repository;

import com.ggomarighetti.tracing.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, String> {
}
