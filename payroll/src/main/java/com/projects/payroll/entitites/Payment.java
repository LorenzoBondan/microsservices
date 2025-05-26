package com.projects.payroll.entitites;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal() {
        return dailyIncome * days;
    }
}
