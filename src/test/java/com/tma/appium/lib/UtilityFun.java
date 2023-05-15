package com.tma.appium.lib;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class UtilityFun {
    public String readPropertyValue(String sKey, String sPropertyFileName) {
        System.out.println("Entering into Method : " + Thread.currentThread().getStackTrace()[1].getMethodName());
        try (InputStream input = Files.newInputStream(Paths.get(sPropertyFileName))) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(sKey, "");
        } catch (IOException ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
