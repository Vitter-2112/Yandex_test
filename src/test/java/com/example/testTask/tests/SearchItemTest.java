package com.example.testTask.tests;

import com.example.testTask.model.Item;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void testItem() throws InterruptedException {

        app.getMainPage().goToMarket(By.cssSelector("[data-id='market']"));

        app.getMarkerItem().switchToNextTab();

        app.getMarketHeader().selectComputersDepartment(By.cssSelector("[href*='/catalog--kompiuternaia-tekhnika']"));

        app.getMarkerItem().filterItem(new Item()
                .setItemType("planshety")
                .setPriceFrom("20000")
                .setPriceTo("35000")
                .setBrand("Apple"));

        app.getMarketHeader().pause(3000);
        String item = app.getMarkerItem().getItemNameFromListByOrder(2);
        System.out.println(item);

        String itemName = app.getMarkerItem().getItemNameFromListByOrder(2);
        app.getMarketHeader().searchItemFromSearchBox(itemName);
        app.getMarkerItem().pause(3000);
        String foundItemName = app.getMarkerItem().getItemNameFromListByOrder(1);

        Assert.assertEquals(foundItemName,itemName);


    }



}
