package com.example.quest.dates;


import lombok.Getter;
import lombok.Setter;

import static java.util.Objects.isNull;

@Getter
@Setter
public class Level {

    private int id;
    private String question;
    private String positiveText;
    private Level nextLevel;
    private String negativeText;
    private Level failLevel;


    public Level(int level, String text, String positiveText, String negativeText) {
        this.id = level;
        this.question = text;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
    }
    public Level(int level, String text) {
        this.id = level;
        this.question = text;
    }
}
