package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.WebElementActions;



public abstract class Page {
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private String PAGE;
    public WebDriver webDriver;
    public WebElementActions web;


    public Page(WebDriver dr, String page) {
        webDriver = dr;
        PAGE = page;
        web = new WebElementActions(dr);
    }

    public boolean openPage(){
        try{
            log.info("Start open page.");
            webDriver.get(PAGE);
            webDriver.getCurrentUrl();
        } catch (Exception e){
            log.error("Error in open page!\n");
            return false;
        }
        log.info("Page open successful.");
        return true;
    }

}
