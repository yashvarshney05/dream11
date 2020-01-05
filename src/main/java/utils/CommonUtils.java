package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import core.Constants;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;


public class CommonUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
    private static final Properties ENV_PROPERTIES = SystemEnvironmentVariables.createEnvironmentVariables().getProperties();
    private static Map<String, Object> POS_PROPERTIES;

    public static String getEnvProperty(String propertyName) {
        return ENV_PROPERTIES.getProperty(propertyName);
    }

    public static boolean isStringNull(String string) {
        return string == null || string.isEmpty()
                || "".equals(string.trim());
    }

    public static String getBaseUrl() {
        String baseUrl = isStringNull(CommonUtils.getEnvProperty("webdriver.base.url")) ? Constants.DEFAULT_URL : CommonUtils.getEnvProperty("webdriver.base.url");
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.lastIndexOf("/"));
        }
        return baseUrl;
    }


    public static int getImplicitTimeoutInSecs()
    {
        String timeout = CommonUtils.getEnvProperty("webdriver.timeouts.implicitlywait");
        return Integer.parseInt(isStringNull(timeout) ? "5000" : timeout) / 1000;
    }

    public static int getExplicitTimeoutInSecs()
    {
        String timeout = CommonUtils.getEnvProperty("webdriver.wait.for.timeout");
        return Integer.parseInt(isStringNull(timeout) ? "10000" : timeout) / 1000;
    }

}

