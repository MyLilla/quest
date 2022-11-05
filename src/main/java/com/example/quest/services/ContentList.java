package com.example.quest.services;

import com.example.quest.dates.Level;
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
