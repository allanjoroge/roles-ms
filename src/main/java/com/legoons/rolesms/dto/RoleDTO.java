package com.legoons.rolesms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDTO {

    public String id;
    private Long businessUnitId;
    private Long projectId;
    private String sowTitle;
    private Instant startDate;
    private Instant endDate;
    private Integer roleStatus;
    private Instant resourceStartDate;
    private Integer totalHours;
    private Double pctDedicated;
    private Double rate;
    private String comments;
    private List<Long> consultants;
    private List<String> skills;
}
