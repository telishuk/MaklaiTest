package pages;

import org.openqa.selenium.WebDriver;
import utils.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static utils.Fixture.driver;

public class MainPage extends Page{

    private static final String MAIN_URL = PropertyLoader.loadProperty("site.Url");

    public MainPage(WebDriver driver) {
        super(driver, MAIN_URL);
    }

    public void clickOverview() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.scrollingToElement("NavigateMenu");
        web.clickLink("Overview");
    }

    public void clickFacilities() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException, InterruptedException {

        web.clickLink("Facilities");
    }

    public void clickRooms() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("Rooms");
    }

    public void clickLocation() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("Location");
    }

    public void clickReviews() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickLink("Reviews");
    }

    public void inputDate() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.scrollingToElement("CheckForm");
        web.clickButton("Date");
        for (int i = 0; i <= 3; i++){
            web.clickButton("ButtonNext");
        }
        web.clickElement("FirstDate");
        web.clickElement("SecondDate");
    }

    public void inputGuests(String ageChild1, String ageChild2) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickElement("GuestsButton");
        web.clickButton("AddGuests");
        web.clickButton("AddChild");
        web.selectFromList("FirstChildAgeForm", ageChild1);
        web.clickButton("AddChild");
        web.selectFromList("SecondChildAgeForm", ageChild2);
        web.clickElement("GuestsButton");
    }

    public void clickButtonSearchPrice() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("SearchPriceButton");
    }

    public void clickButtonBookNow() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException{
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        web.scrollingToElement("OfferRooms");
        web.clickButton("ButtonBookNow");
    }



}
