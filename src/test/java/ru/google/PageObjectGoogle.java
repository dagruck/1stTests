package ru.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogle {
    private WebDriver chromeDriver;
    WebElement searchField;
    WebElement searchButton;
    WebElement clearButton;

    List<WebElement> searchresult;

    public List<WebElement> getsearchresult() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"rc\"]"));
    }

    PageObjectGoogle(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@aria-label=\"Поиск в Google\"]"));
        clearButton = chromeDriver.findElement(By.xpath("//*[@class=\"clear-button XoaYSb\"]"));
    }

    public void find(String wordFind){
        clearButton.click();
        searchField.click();
        searchField.sendKeys(wordFind);
        searchButton.click();
    }

}
