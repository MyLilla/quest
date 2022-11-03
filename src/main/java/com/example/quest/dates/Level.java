package com.example.quest.dates;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Level {

    private int id;
    private String question;
    private String positiveText;
    private Level nextLevel;
    private String negativeText;
    private String failText;

    public Level(int level, String text, String positiveText, String negativeText) {
        this.id = level;
        this.question = text;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
    }

    public Level(int level, String text, String positiveText, String negativeText, String failText) {
        this.id = level;
        this.question = text;
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        this.failText = failText;
    }

    public Level(int level, String text) {
        this.id = level;
        this.question = text;
    }
}
