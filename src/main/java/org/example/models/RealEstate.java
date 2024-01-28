package org.example.models;

import org.example.Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RealEstate {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public String region;
    public String district;
    public String quartel;
    public String street;
    public String[] description;
    public String[] photos;
    public String youtube;
    public String tour3d;
    public String price;
    public String phoneNo;
    public String email;
    public boolean[] personalInfoCheckBox;

    public RealEstate(String region, String district, String quartel, String street, String[] description, String[] photos, String youtube, String tour3d, String price, String phoneNo, String email, boolean[] personalInfoCheckBox) {
        this.region = region;
        this.district = district;
        this.quartel = quartel;
        this.street = street;
        this.description = description;
        this.photos = photos;
        this.youtube = youtube;
        this.tour3d = tour3d;
        this.price = price;
        this.phoneNo = phoneNo;
        this.email = email;
        this.personalInfoCheckBox = personalInfoCheckBox;
    }

    public void fill() {
        fillLocation();
        fillDescription();
        uploadPhotos();
        fillYouTube();
        fillTour3d();
        fillPrice();
        fillPhoneNum();
        fillEmail();
        fill3BottomCheckboxes();
    }


    public void fillLocation() {
        fillRegion();
        fillDistrict();
        fillQuartel();
        fillStreet();
    }

    public void fillRegion() {
        driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[3]/span[1]/span")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(0).findElements(By.tagName("li"));
        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).getText().equalsIgnoreCase(region)) {
                lis.get(i).click();
                break;
            }
        }
    }

    public void fillDistrict() {
        wait(1000);
        driver.findElement(By.xpath("//*[@id=\"district\"]/span")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(1).findElements(By.tagName("li"));
        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).getText().toLowerCase().contains(district.toLowerCase())) {
                lis.get(i).click();
                break;
            }
        }
    }

    public void fillQuartel() {
        wait(1000);
        String classList = driver.findElement(By.id("quartalField")).getAttribute("class");
        if (classList.contains("hide") || classList.contains("disable")) {
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"quartalField\"]/span[1]/span[2]")).click();
        List<WebElement> lis = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));
        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).getText().equalsIgnoreCase(quartel)) {
                lis.get(i).click();
                break;
            }
        }
    }

    public void fillStreet() {
        wait(500);
        String classList = driver.findElement(By.id("streetField")).getAttribute("class");
        if (classList.contains("disabled")) {
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"streetField\"]/span[1]/span[2]")).click();
        List<WebElement> lis;
        try {
            lis = driver.findElements(By.className("dropdown-input-values-address")).get(3).findElements(By.tagName("li"));
        } catch (Exception e) {
            lis = driver.findElements(By.className("dropdown-input-values-address")).get(2).findElements(By.tagName("li"));
        }

        for (int i = 0; i < lis.size(); i++) {
            if (lis.get(i).getText().equalsIgnoreCase(street.toLowerCase())) {
                lis.get(i).click();
                break;
            }
        }
    }

    public void fillDescription() {
        if (!this.description[0].equals("")) {
            driver.findElement(By.name("notes_lt")).sendKeys(this.description[0]);

        }
        if (!this.description[1].equals("")) {
            driver.findElement(By.className("lang-en-label")).click();
            driver.findElement(By.name("notes_en")).sendKeys(this.description[1]);

        }
        if (!this.description[2].equals("")) {
            driver.findElement(By.className("lang-ru-label")).click();
            driver.findElement(By.name("notes_ru")).sendKeys(this.description[2]);

        }
    }


    public void uploadPhotos() {

        if (photos.length == 0) {
            System.out.println("No photos to upload");
            return;
        }

        for (int i = 0; i < photos.length; i++) {
            if (!photos[i].isEmpty()) {
                driver.findElement(By.xpath("//*[@id=\"uploadPhotoBtn\"]/input")).sendKeys(this.photos[i]);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"photosThumbsList\"]/div[" + (i + 1) + "]/a")));
            }
        }

        for (int i = 0; i < photos.length; i++) {
            if (!photos[i].isEmpty()) {
                WebElement deletePhotos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ctrl-delete")));
                deletePhotos.click();
            }
        }
    }

    public void fillYouTube() {
        driver.findElement(By.name("Video")).sendKeys(this.youtube);

    }

    public void fillTour3d() {
        driver.findElement(By.name("tour_3d")).sendKeys(this.tour3d);

    }

    public void fillPrice() {
        driver.findElement(By.xpath("//*[@id=\"priceField\"]")).sendKeys(this.price);
    }

    public void fillPhoneNum() {
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys(this.phoneNo);
    }

    public void fillEmail() {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(this.email);
    }

    public void fill3BottomCheckboxes() {
        WebElement ulElement = driver.findElement(By.className("new-object-from"));
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));
        if (personalInfoCheckBox[0]) {
            liElements.get(liElements.size() - 5).findElement(By.tagName("span")).click();
        }
        if (personalInfoCheckBox[1]) {
            liElements.get(liElements.size() - 4).findElement(By.tagName("span")).click();
        }
        if (personalInfoCheckBox[2]) {
            liElements.get(liElements.size() - 3).findElements(By.tagName("span")).get(1).click();
        }
    }

    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

}
