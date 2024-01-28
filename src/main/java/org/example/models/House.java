package org.example.models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class House extends RealEstate {

    public String addressNo;

    public boolean addressNumberTickBoxDoNotShow;
    public String rcNo;

    public boolean rcNoTickBoxDoNotShow;
    public String area;
    public String houseHeight;
    public String areaLot;
    public boolean areaLotTickBoxWithoutAreaLot;
    public String buildYear;
    public boolean clickBoxRenovated;
    public String renovatedYear;
    public String buildingType;
    public String houseType;
    public String houseState;
    public String[] warmSystems;


    public House(String region, String district, String quartel, String street, String[] description, String[] photos, String youtube, String tour3d, String price, String phoneNo, String email, boolean[] personalInfoCheckBox, String addressNo, boolean addressNumberTickBoxDoNotShow, String rcNo, boolean rcNoTickBoxDoNotShow, String area, String houseHeight, String areaLot, boolean areaLotTickBoxWithoutAreaLot, String buildYear, boolean clickBoxRenovated, String renovatedYear, String buildingType, String houseType, String houseState, String[] warmSystems) {
        super(region, district, quartel, street, description, photos, youtube, tour3d, price, phoneNo, email, personalInfoCheckBox);
        this.addressNo = addressNo;
        this.addressNumberTickBoxDoNotShow = addressNumberTickBoxDoNotShow;
        this.rcNo = rcNo;
        this.rcNoTickBoxDoNotShow = rcNoTickBoxDoNotShow;
        this.area = area;
        this.houseHeight = houseHeight;
        this.areaLot = areaLot;
        this.areaLotTickBoxWithoutAreaLot = areaLotTickBoxWithoutAreaLot;
        this.buildYear = buildYear;
        this.clickBoxRenovated = clickBoxRenovated;
        this.renovatedYear = renovatedYear;
        this.buildingType = buildingType;
        this.houseType = houseType;
        this.houseState = houseState;
        this.warmSystems = warmSystems;
    }

    @Override
    public void fill() {
        super.fill();
        fillAddressNo();
        fillAddressNumberTickBoxDoNotShow();
        fillRcNo();
        fillRcNoTickBoxDoNotShow();
        fillArea();
        fillHouseHeight();
        fillAreaLot();
        fillAreaLotTickBoxWithoutAreaLot();
        fillBuildYear();
        fillClickBoxRenovated();
        fillRenovatedYear();
        fillBuildingType();
        fillHouseType();
        fillHouseState();
        fillWarmSystem();
        fillSubmitButton();
    }

    public void fillAddressNo() {
        driver.findElement(By.name("FHouseNum")).sendKeys(this.addressNo);
    }

    public void fillAddressNumberTickBoxDoNotShow(){
        if (this.addressNumberTickBoxDoNotShow){
            driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/ul/li[7]/div/div/label")).click();
        }
    }

    public void fillRcNo() {
        driver.findElement(By.name("RCNumber")).sendKeys(this.rcNo);
    }

    public void fillRcNoTickBoxDoNotShow(){
        if (this.rcNoTickBoxDoNotShow){
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[11]/div[2]/div/label")).click();
        }
    }

    public void fillArea() {
        driver.findElement(By.name("FAreaOverAll")).sendKeys(this.area);
    }

    public void fillHouseHeight() {
        if (this.houseHeight.equals("1")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(14) > div > div:nth-child(2) > div.input-button-text")).click();
            return;
        }
        if (this.houseHeight.equals("2")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(14) > div > div:nth-child(3) > div.input-button-text")).click();
            return;
        }
        driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(14) > div > span > input[type=text]")).sendKeys(this.houseHeight);
    }

    public void fillAreaLot() {
        driver.findElement(By.id("fieldFAreaLot")).sendKeys(this.areaLot);
    }

    public void fillAreaLotTickBoxWithoutAreaLot(){
        if (this.areaLotTickBoxWithoutAreaLot){
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(15) > div > div > label > span")).click();
        }
    }

    public void fillBuildYear() {
        driver.findElement(By.name("FBuildYear")).sendKeys(this.buildYear);
    }

    public void fillClickBoxRenovated(){
        if (this.clickBoxRenovated){
            driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[16]/div[2]/div/div/label/span")).click();
        }
    }

    public void fillRenovatedYear() {
        if (!this.renovatedYear.equals("")) {
            driver.findElement(By.id("FRenovatedYear")).sendKeys(this.renovatedYear);
        }
    }

    public void fillBuildingType() {
        if (this.buildingType.equals("Namas (gyvenamasis)")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(2)")).click();
            return;
        }
        if (this.buildingType.equals("Namo dalis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(3) > div.input-button-text")).click();
            return;
        }
        if (this.buildingType.equals("Sodo namas")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(4) > div.input-button-text")).click();
            return;
        }
        if (this.buildingType.equals("Sublokuotas namas")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(5) > div.input-button-text")).click();
            return;
        }
        if (this.buildingType.equals("Sodyba")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(6) > div.input-button-text")).click();
            return;
        }
        if (this.buildingType.equals("Kita (nukeliamas, projektas, kt.)")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(17) > div > div:nth-child(7) > div.input-button-text")).click();
        }
    }

    public void fillHouseType() {
        if (this.houseType.equals("Mūrinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(2) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Blokinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(3) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Monolitinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(4) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Medinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(5) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Karkasinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(6) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Rąstinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(7) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Skydinis")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(8) > div.input-button-text")).click();
            return;
        }
        if (this.houseType.equals("Kita")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(18) > div > div:nth-child(9) > div.input-button-text")).click();
        }

    }

    public void fillHouseState() {
        if (this.houseState.equals("Įrengtas")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(2) > div.input-button-text")).click();
            return;
        }
        if (this.houseState.equals("Dalinė apdaila")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(3) > div.input-button-text")).click();
            return;
        }
        if (this.houseState.equals("Neįrengtas")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(4) > div.input-button-text")).click();
            return;
        }
        if (this.houseState.equals("Nebaigtas statyti")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(5) > div.input-button-text")).click();
            return;
        }
        if (this.houseState.equals("Pamatai")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(6) > div.input-button-text")).click();
            return;
        }
        if (this.houseState.equals("Kita")) {
            driver.findElement(By.cssSelector("#newObjectForm > ul > li:nth-child(19) > div > div:nth-child(7) > div.input-button-text")).click();

        }

    }

    public void fillWarmSystem() {
        List<WebElement> checkboxElements = driver.findElements(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]//input[@type='checkbox']"));
        for (String purpose : this.warmSystems) {
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
