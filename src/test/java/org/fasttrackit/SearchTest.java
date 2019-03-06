package org.fasttrackit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    @Test
    public void searchByOneKeyWordTest(){

        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://fasttrackit.org/selenium-test");

        driver.findElement(By. className("input-text")).
            sendKeys("vase" + Keys.ENTER);
      //  driver.findElement(By.partialLinkText("OMEN")).click();


        List<WebElement> productNameContainers =
                driver.findElements(By.cssSelector(".product-name> a"));

        for (WebElement container : productNameContainers) {
            String productName = container.getText();
            assertThat("Some of the products names do not contain a search keyword",
           productName, containsString(keyword.toUpperCase)) );


        }
    }
}
