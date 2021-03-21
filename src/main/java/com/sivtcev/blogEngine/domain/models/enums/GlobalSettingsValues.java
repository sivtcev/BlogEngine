package com.sivtcev.blogEngine.domain.models.enums;

import lombok.Getter;

/**
 * <h1>Global settings enum class</h1>
 * This class defines the values of the 'code' variable in the class {@link com.sivtcev.blogEngine.domain.models.GlobalSetting}
 * @author sivtcev
 * @version 0.1.1
 * @since 2021-03-17
 */

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
