package com.example.testTask.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;
    MainPageHelper mainPage;
    MarketItemHelper markerItem;
    MarketHeaderHelper marketHeader;

    public void init() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();

        openSite("https://yandex.ru/");

        mainPage = new MainPageHelper(wd);
        markerItem = new MarketItemHelper(wd);
        marketHeader = new MarketHeaderHelper(wd);
    }

    public MainPageHelper getMainPage() {
        return mainPage;
    }

    public MarketItemHelper getMarkerItem() {
        return markerItem;
    }

    public MarketHeaderHelper getMarketHeader() {
        return marketHeader;
    }

    public void stop() {
        wd.quit();
    }

    public void openSite(String url) {
        wd.navigate().to(url);
    }

}
