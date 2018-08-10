package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.*;

import java.util.Set;


public class TestMainForm extends Fixture {

    @Test
    public void clickNavigationMenu() throws Exception, NoSuchLocatorException {
        hotel.mainPage.openPage();
        hotel.mainPage.clickOverview();
        hotel.screenShotMaker.takeScreenShot("Overview");
        hotel.mainPage.clickFacilities();
        hotel.screenShotMaker.takeScreenShot("Facilities");
        hotel.mainPage.clickRooms();
        hotel.screenShotMaker.takeScreenShot("Rooms");
        hotel.mainPage.clickLocation();
        hotel.screenShotMaker.takeScreenShot("Location");
        hotel.mainPage.clickReviews();
        hotel.screenShotMaker.takeScreenShot("Reviews");
    }

    @Parameters({"ageChild1", "ageChild2"})
    @Test
    public void inputCheckFormDate(String age1, String age2) throws Exception, NoSuchLocatorException {
        hotel.mainPage.openPage();
        hotel.mainPage.inputDate();
        hotel.mainPage.inputGuests(age1, age2);
        Assert.assertEquals(hotel.mainPage.web.getElementsText("FieldGuests"), "5");
        Assert.assertEquals(hotel.mainPage.web.getElementsText("FieldRooms"), "1");

        Set<String> oldWindowsSet = driver.getWindowHandles();
        hotel.mainPage.clickButtonSearchPrice();
        String newWindowHandle = (new WebDriverWait(driver, 10))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindowHandle);
        hotel.mainPage.clickButtonBookNow();
        Thread.sleep(2000);
        hotel.screenShotMaker.takeScreenShot("Reservation");
        Assert.assertEquals(hotel.mainPage.web.getElementsText("ArrivalDate"), "2019-01-24");
        Assert.assertEquals(hotel.mainPage.web.getElementsText("DepartureDate"), "2019-01-25");
        Assert.assertEquals(hotel.mainPage.web.getElementsText("NumberGuests"), "3 Взрослых,\n" +
                "2 Детей");
    }


}