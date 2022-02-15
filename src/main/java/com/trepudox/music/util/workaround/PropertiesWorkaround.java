package com.trepudox.music.util.workaround;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesWorkaround {

    private static String selflink;

    @Value("${selflink}")
    private synchronized void setSelflink(String selflink) {
        PropertiesWorkaround.selflink = selflink;
    }

    public static String retrieveSelflink() {
        return PropertiesWorkaround.selflink;
    }

}
