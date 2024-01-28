package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Plot extends RealEstate {
    public String addressNo;
    public boolean addressNumberTickBoxDoNotShow;
    public String rcNo;
    public boolean rcNoTickBoxDoNotShow;
    public String area;
    public String[] purposes;

    public Plot(String region, String district, String quartel, String street, String[] description, String[] photos, String youtube, String tour3d, String price, String phoneNo, String email, boolean[] personalInfoCheckBox, String addressNo, boolean addressNumberTickBoxDoNotShow, String rcNo, boolean rcNoTickBoxDoNotShow, String area, String[] purposes) {
        super(region, district, quartel, street, description, photos, youtube, tour3d, price, phoneNo, email, personalInfoCheckBox);
        this.addressNo = addressNo;
        this.addressNumberTickBoxDoNotShow = addressNumberTickBoxDoNotShow;
        this.rcNo = rcNo;
        this.rcNoTickBoxDoNotShow = rcNoTickBoxDoNotShow;
        this.area = area;
        this.purposes = purposes;
    }

    @Override
    public void fill() {
        super.fill();
        fillAddressNo();
        fillAddressNumberTickBoxDoNotShow();
        fillRcNo();
        fillRcNoTickBoxDoNotShow();
        fillArea();
        fillPurposes();
        fillSubmitButton();


    }

    public void fillAddressNo() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/span[1]/input")).sendKeys(this.addressNo);
    }

    public void fillAddressNumberTickBoxDoNotShow() {
        if (this.addressNumberTickBoxDoNotShow) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[7]/div/div/label")).click();
        }
    }

    public void fillRcNo() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[1]/input")).sendKeys(this.rcNo);
    }

    public void fillRcNoTickBoxDoNotShow() {
        if (this.rcNoTickBoxDoNotShow) {
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[2]/div/label")).click();
        }
    }

    public void fillArea() {
        driver.findElement(By.xpath("//*[@id=\"fieldFAreaOverAll\"]")).sendKeys(this.area);
    }

    public void fillPurposes() {
        List<WebElement> checkboxElements = driver.findElements(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]//input[@type='checkbox']"));
        for (String purpose : this.purposes) {
            for (WebElement checkboxElement : checkboxElements) {
                String checkboxValue = checkboxElement.getAttribute("data-title");
                if (purpose.equalsIgnoreCase(checkboxValue)) {
                    WebElement spanElement = checkboxElement.findElement(By.xpath("following-sibling::label"));
                    spanElement.click();
                    break;
                }
            }
        }
    }


    public void fillSubmitButton() {
        driver.findElement(By.id("submitFormButton")).click();
    }

}
