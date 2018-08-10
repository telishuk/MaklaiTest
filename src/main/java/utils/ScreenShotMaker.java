package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    protected WebDriver driver;
    private static String screenShotDirectory;

    public ScreenShotMaker(WebDriver driver) {
        this.driver = driver;
        screenShotDirectory = PropertyLoader.loadProperty("screenshot.folder");
        File screenFolder = new File(screenShotDirectory);
        if (!screenFolder.exists())
            screenFolder.mkdirs();
    }

    public void takeScreenShot(String scrName) {
        String scrFormat = PropertyLoader.loadProperty("screenshot.format");

        Augmenter augmenter = new Augmenter();

        File scrFile = ((TakesScreenshot)augmenter.augment(driver)).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenShotDirectory + "/" + scrName + scrFormat));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
