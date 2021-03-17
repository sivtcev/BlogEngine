package com.sivtcev.blogEngine.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 *
 */

@Data
@Entity(name = "captcha_codes")
public class CaptchaCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime time;

    @Column(name = "code", nullable = false, columnDefinition = "SMALLINT")
    private Integer code;

    @Column(name = "secret_code", nullable = false, columnDefinition = "SMALLINT")
    private Integer secretCode;
}
