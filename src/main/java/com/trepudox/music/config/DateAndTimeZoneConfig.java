package com.trepudox.music.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.util.TimeZone;

@Configuration
public class DateAndTimeZoneConfig {

    @Bean
    public void setZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of("UTC")));
    }

}
