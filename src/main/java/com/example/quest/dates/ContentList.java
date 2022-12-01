package com.example.quest.dates;

import lombok.Getter;

import java.util.*;

public abstract class ContentList {
    @Getter
    private final List<Level> levelsList;

    protected ContentList() {
        this.levelsList = createLevelsList();
    }

    protected abstract List<Level> createLevelsList();
}
