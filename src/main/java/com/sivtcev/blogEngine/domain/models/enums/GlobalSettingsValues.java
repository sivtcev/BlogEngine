package com.sivtcev.blogEngine.domain.models.enums;

import lombok.Getter;

public enum GlobalSettingsValues {
    MULTIUSER_MODE("Многопользовательский режим"),
    POST_PRE_MODERATION("Премодерация постов"),
    STATISTICS_IS_PUBLIC("Показывать всем статистику блога");

    @Getter
    private final String name;

    GlobalSettingsValues(String name){
        this.name = name;
    }

}
