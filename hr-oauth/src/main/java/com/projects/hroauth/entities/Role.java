package com.projects.hroauth.entities;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Long id;
    private String authority;
}
