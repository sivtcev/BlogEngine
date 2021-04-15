package com.sivtcev.blogEngine;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;

@TestConfiguration
@ComponentScan("com.sivtcev.blogEngine.domain.services")
public class ServiceTestConfiguration {
}
