package com.projects.payroll.entitites;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Worker {

    private Long id;
    private String name;
    private Double dailyIncome;
}
