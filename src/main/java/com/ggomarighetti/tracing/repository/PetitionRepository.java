package com.ggomarighetti.tracing.repository;

import com.ggomarighetti.tracing.entity.PetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetitionRepository extends JpaRepository<PetitionEntity, String> {
}
