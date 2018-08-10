package utils;

import org.openqa.selenium.By;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readouts {
    public static String uiMappingFile = "src/main/resources/UIMapping.Properties";

    /*
     *  Return value from .properties file
     */
    public static String getValueFromFile(String key, String fileName) throws IOException {
        Properties p = new Properties();
        FileInputStream cfg = new FileInputStream(fileName);
        p.load(cfg);
        cfg.close();
        return(p.getProperty(key));
    }


    /*
     *  Return By class with finding method and target for WebElement from UI mapping file
     */
    public static By ui(String key) throws IOException, CloneNotSupportedException, IllegalAccessException, InstantiationException, NoSuchLocatorException {
        String[] partsOfLocator = getValueFromFile(key, uiMappingFile).split("\"");
        String findMethod = partsOfLocator[0].substring(0, partsOfLocator[0].length() - 1);
        String target = partsOfLocator[1];
        if (findMethod.equals("id")) {
            return By.id(target);
        } else if (findMethod.equals("xpath")) {
            return By.xpath(target);
        } else if (findMethod.equals("name")) {
            return By.name(target);
        } else if (findMethod.equals("class")) {
            return By.className(target);
        } else if (findMethod.equals("cssSelector")) {
            return By.cssSelector(target);
        } else {
            throw new NoSuchLocatorException("<--------- Locator not found --------->");
        }
    }

}
