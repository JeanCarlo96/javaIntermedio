package com.repaso.gatosapp;

import java.io.*;
import java.util.Properties;

/**
 *
 * @author Jean Marchesini
 */
public class ApiKey {

    private ApiKey() {
    }

    public static String obtenerApiKey() {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        String apiKey = "";

        try {
            entrada = new FileInputStream("config.properties");

            propiedades.load(entrada);
            apiKey = propiedades.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiKey;
    }

}
