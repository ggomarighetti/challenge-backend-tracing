package com.ggomarighetti.tracing.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatsResponseDto {
    private double farthestDistance;
    private double nearestDistance;
    private double averageDistance;
}
