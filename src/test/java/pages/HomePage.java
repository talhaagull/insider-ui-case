package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Why Insider")
    public WebElement exploreInsider;

    @FindBy(xpath = "//a[contains(text(),'Company')]")
    public WebElement companyMenu;

    @FindBy(xpath = "//a[text()='Careers']")
    public WebElement careersOption;

    public void goHomePage(){
        CommonMethods.goToUrl("homePage");
    }

    public void homePageIsOpened(){
        CommonMethods.elementIsDisplayed(exploreInsider);
    }

    public void clickCompanyMenu(){
        CommonMethods.clickElement(companyMenu);
    }

    public void clickCareersOption(){
        CommonMethods.clickElement(careersOption);
    }

}
