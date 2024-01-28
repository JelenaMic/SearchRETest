package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchRE extends RealEstate {
    public String objectType;

    public SearchRE(String region, String district, String quartel, String street, String[] description, String[] photos, String youtube, String tour3d, String price, String phoneNo, String email, boolean[] personalInfoCheckBox, String objectType) {
        super(region, district, quartel, street, description, photos, youtube, tour3d, price, phoneNo, email, personalInfoCheckBox);
        this.objectType = objectType;
    }

    @Override
    public void fill() {
        super.fill();
        fillObjectType();
        fillSubmitButton();
    }

    public void fillObjectType() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/span")).click();
        List<WebElement> list = driver.findElement(By.className("dropdown-input-values")).findElements(By.tagName("li"));
        for (int i = 0; i < list.size(); i++) {
            String objectTypeOptions = list.get(i).getText();
            if (objectTypeOptions.equalsIgnoreCase(this.objectType)) {
                list.get(i).click();
                break;
            }
        }
    }

    public void fillSubmitButton() {
        driver.findElement(By.id("submitFormButton")).click();
    }

    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }


}


