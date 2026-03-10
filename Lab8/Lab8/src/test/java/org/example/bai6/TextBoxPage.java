package org.example.bai6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/** Bai 6.2 - Page Object Model cho https://demoqa.com/text-box */
public class TextBoxPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "userName")       private WebElement nameInput;
    @FindBy(id = "userEmail")      private WebElement emailInput;
    @FindBy(id = "currentAddress") private WebElement addressInput;
    @FindBy(id = "submit")         private WebElement submitButton;
    @FindBy(id = "output")         private WebElement outputSection;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigate() { driver.get("https://demoqa.com/text-box"); }

    public void fillAndSubmit(String name, String email, String address) {
        nameInput.clear();    nameInput.sendKeys(name);
        emailInput.clear();   emailInput.sendKeys(email);
        addressInput.clear(); addressInput.sendKeys(address);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", submitButton);
        submitButton.click();
    }

    public boolean isOutputDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(outputSection));
            String cls = outputSection.getAttribute("class");
            return outputSection.isDisplayed() && cls != null && cls.contains("show");
        } catch (Exception e) { return false; }
    }

    public String getOutputText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(outputSection));
            return outputSection.getText();
        } catch (Exception e) { return ""; }
    }

    public String getOutputName() {
        try { return driver.findElement(By.id("name")).getText(); }
        catch (Exception e) { return ""; }
    }
}
