package com.sivtcev.blogEngine.presentation.api.response;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class InitResponse {
    @Value("${blog.init.title}")
    private String title;
    @Value("${blog.init.subtitle}")
    private String subtitle;
    @Value("${blog.init.phone}")
    private String phone;
    @Value("${blog.init.email}")
    private String email;
    @Value("${blog.init.copyright}")
    private String copyright;
    @Value("${blog.init.copyrightForm}")
    private String copyrightForm;
}
