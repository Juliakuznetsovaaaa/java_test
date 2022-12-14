package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@id='hook_Block_TFCounter']")
    private WebElement userMenu;

    @FindBy (xpath = "//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div")
    private WebElement userName;

    public String getUserName() {
        String name = userName.getText();
        return name;
    }

}