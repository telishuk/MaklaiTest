package pages;

import org.openqa.selenium.WebDriver;
import utils.ScreenShotMaker;
import utils.WebElementActions;


public class Hotel {
    public WebElementActions web;
    public MainPage mainPage;
    public ScreenShotMaker screenShotMaker;

    public Hotel(WebDriver driver) {
        web = new WebElementActions(driver);
        mainPage = new MainPage(driver);
        screenShotMaker = new ScreenShotMaker(driver);
    }


}
