package com;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import org.junit.Test;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
public class LoginTest{
public static LoginPage loginPage;
public static ProfilePage profilePage;
public static WebDriver driver;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia\\IdeaProjects\\Untitled5\\chromedriver.exe");
        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ok.ru/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
    }
    @Test
    public void loginTest(){
        BasicConfigurator.configure();

        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickLoginBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);

    }
   @AfterClass
    public static void tearDown() {
        driver.quit(); }
}
