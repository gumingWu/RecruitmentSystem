package com.recruit.server.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.recruit.server.mapper")
public class MybatisConfig {
}
