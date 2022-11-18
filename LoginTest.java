package com;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.apache.log4j.BasicConfigurator;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
public class LoginTest{
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static NotionMunipulation notionMunipulation;
    public static WebDriver driver;


    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
        driver=new ChromeDriver();
        loginPage=new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        notionMunipulation=new NotionMunipulation(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://ok.ru/dk?st.cmd=anonymMain&st.layer.cmd=PopLayerClose");
    }
    @Test
    public void loginTest(){
        BasicConfigurator.configure();
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);
    }
    @DisplayName("Публикация заметки, проверка текста заметки")
    @Test
    public void notionTest(){
        notionMunipulation.clickNotionBtm();
        notionMunipulation.inputZametka("hochy denyak");
        notionMunipulation.pushNotion();
        String notion = notionMunipulation.getNotionText();
        Assert.assertEquals(ConfProperties.getProperty("notion"), notion);
        /*notionMunipulation.clickLenta();
        notionMunipulation.clicPersonsNotion();
        notionMunipulation.clickNotionMenu();
        notionMunipulation.clickNotionDelete();*/

    }

   /* @AfterClass
    public static void tearDown() {

        driver.quit(); }*/
}
