package com.sivtcev.blogEngine.domain.models;

import com.sivtcev.blogEngine.domain.models.enums.GlobalSettingsValues;
import com.sivtcev.blogEngine.domain.models.enums.ModerationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *
 */

@Data
@Entity(name = "global_settings")
public class GlobalSetting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "code", nullable = false, columnDefinition = "VARCHAR", length = 255)
    private GlobalSettingsValues code;

    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR", length = 255)
    private String name;

    @Column(name = "value", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean value;

}
