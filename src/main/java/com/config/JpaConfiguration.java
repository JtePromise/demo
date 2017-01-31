package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ganluting on 17/1/9.
 */
@Configuration
@EnableJpaRepositories("com.dao.*")
public class JpaConfiguration {



}
