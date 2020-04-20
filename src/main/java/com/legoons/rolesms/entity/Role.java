package com.legoons.rolesms.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "roles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
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
