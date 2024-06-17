package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonMethods;
import utilities.Driver;

public class CareersPage {

    public CareersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h3[text()='Customer Success']")
    public WebElement customerSuccessTitle;

    @FindBy(xpath = "//h3[text()='Sales']")
    public WebElement salesTitle;

    @FindBy(xpath = "//h3[text()='Product & Engineering']")
    public WebElement productAndEngineeringTitle;

    @FindBy(linkText = "See all teams")
    public WebElement seeAllTeamsButton;

    @FindBy(xpath = "//h3[contains(text(),'Our Locations')]")
    public WebElement locationsTitle;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement lifeAtInsiderTitle;

    public void areCareerPageBlocksOpen(){
        CommonMethods.elementIsDisplayed(customerSuccessTitle);
        CommonMethods.elementIsDisplayed(salesTitle);
        CommonMethods.elementIsDisplayed(productAndEngineeringTitle);
        CommonMethods.elementIsDisplayed(seeAllTeamsButton);
        CommonMethods.elementIsDisplayed(locationsTitle);
        CommonMethods.elementIsDisplayed(lifeAtInsiderTitle);
    }


}
