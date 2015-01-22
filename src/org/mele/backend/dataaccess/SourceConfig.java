package org.mele.backend.dataaccess;

/**
 * Created by mariodimitrov on 12/26/14.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SourceConfig {
    private Properties properties;

    public Properties getProperties() {
        if (this.properties == null) {
            try {
                this.properties = generateProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    private Properties generateProperties() throws IOException {

        Properties properties = new Properties();
        String propFileName = "config/config.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        String user = properties.getProperty("databaseUser");
        String password = properties.getProperty("databasePassword");
        String url = properties.getProperty("databaseUrl");
        String dbName = properties.getProperty("databaseName");
        return properties;
    }

    public static void main(String[] args) throws IOException {

    }
}

