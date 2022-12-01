package com.example.quest.dates;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Level {

    private int id;
    private String question;
    private String positiveText;

    private Level nextLevel;
    private String negativeText;
    private String failText;
}
