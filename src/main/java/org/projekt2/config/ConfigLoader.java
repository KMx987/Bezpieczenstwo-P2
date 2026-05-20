package org.projekt2.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {

    public static Properties load() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("config_encrypted.properties"));
        return props;
    }
}