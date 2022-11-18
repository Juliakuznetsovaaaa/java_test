package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotionMunipulation {
    public WebDriver driver;
    public NotionMunipulation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@href, '/post')]")
    private WebElement notionBtm;

    public void clickNotionBtm(){
        notionBtm.click();
    }

    @FindBy (xpath = "//*[@id=\"hook_Block_pfnull\"]/div[2]/div[1]/div/div/div[2]")
    WebElement inputNotion;

    @FindBy (xpath = "//*[contains(@data-l, 't,button.submit')]")
    WebElement pushBtm;

    public void inputZametka(String passwd) {
        inputNotion.sendKeys(passwd); }

    public void pushNotion(){
        pushBtm.click();
    }

    @FindBy(xpath = "//*[contains(@class, 'media-text_cnt_tx emoji-tx textWrap')]")
    WebElement notionText;

    public String getNotionText() {
        String notion = notionText.getText();
        return notion;
    }
    /*@FindBy (xpath = "//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div")
    WebElement lenta;
    @FindBy(xpath = "//*[@id=\"hook_Block_mediatopic_155409660029769\"]/div[3]/div[3]/div/div/span")
    WebElement notionMenu;
    @FindBy(xpath = "//*[@id=\"hook_Block_ShortcutMenu\"]")
    WebElement notionDelete;

    @FindBy (xpath = "//*[@id=\"hook_Block_MiddleColumnTopCard_MenuUser\"]/div/a[4]")
    WebElement personsNotion;

    public void clicPersonsNotion(){
        personsNotion.click();
    }

    public void clickLenta(){
        lenta.click();
    }

    public void clickNotionMenu(){
        notionMenu.click();
    }
    public void clickNotionDelete(){
        notionDelete.click();
    }*/




}
