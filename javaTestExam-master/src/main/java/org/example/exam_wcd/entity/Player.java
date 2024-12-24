package org.example.exam_wcd.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {
    private Long playerId;
    private String name;
    private String fullName;
    private String age;
    private Integer indexId;
}
