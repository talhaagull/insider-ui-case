package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class CommonMethods {

    public static void goToUrl(String urlKey) {
        String url = ConfigReader.getProperty(urlKey);
        Driver.getDriver().get(url);
    }

    public static void clickElement(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.scrollToElement(element).perform();
        Assert.assertTrue(element.isDisplayed(), element + " is not displayed.");
        actions.click(element).perform();
    }

    public static void JavascriptClick(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static String takeScreenshot(WebDriver driver, String name) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(target));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static void elementIsDisplayed(WebElement element) {
        scrollIntoView(element);
        Assert.assertTrue(element.isDisplayed(), element + " is not displayed.");
    }

    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void switchToNewWindow() {
        WebDriver driver = Driver.getDriver();
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void selectFromMenu(WebElement element, String option) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("option")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[normalize-space(.) = '" + option + "']")));
        String script = "var select = arguments[0];"
                + "for(var i = 0; i < select.options.length; i++) {"
                + " if(select.options[i].text == arguments[1]) {"
                + " select.selectedIndex = i;"
                + " select.dispatchEvent(new Event('change'));"
                + " break;"
                + " }"
                + "}";
        ((JavascriptExecutor) Driver.getDriver()).executeScript(script, element, option);

        Select dropdown = new Select(element);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedValue = selectedOption.getText();
        Assert.assertEquals(selectedValue, option, "Selected and expected value are different!");
    }

}
