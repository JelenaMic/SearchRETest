import org.example.Helper;
import org.example.models.Plot;
import org.example.models.SearchRE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SearchRETest {
    static WebDriver driver;
    static WebDriverWait wait;

    @Test
    public void positiveRegistrationTest() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"Ieškau vieno kambario buto nuomai.", "Hello. I am looking for a one-room apartment for rent.", "ищу в аренду однокомнатную квартиру"}, new String[]{"/Users/denismichaliov/Documents/cat.jpg", "/Users/denismichaliov/Documents/Leksikk 3.jpg", "/Users/denismichaliov/Documents/Leks.jpeg"}, "https://www.youtube.com/watch?v=pkWCQAC_mwU", "www.tour3d.com", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.className("plan-choose-button")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestOnlySpecialCharactersDescription() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{",;:{}()[]&!?#%^*=~`|/<>|/", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[13]/label/span[2]")).getText();
        Assert.assertEquals(actual, "Netinkamas teksto formatas");
    }

    @Test
    public void negativeRegistrationTestWrongYoutubeLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "www.youtube.com", "", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[17]/span[3]"))).getText();
        Assert.assertEquals(actual, "Blogas embed kodas");
    }

    @Test
    public void negativeRegistrationTestWrong3DLink() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "www.tour3dcom", "400", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[18]/span[3]")).getText();
        Assert.assertEquals(actual, "Bloga nuoroda");
    }

    @Test
    public void positiveRegistrationTestPriceWithDot() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199.99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai pirkti");
        sre.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199.99");
    }

    @Test
    public void positiveRegistrationTestPriceWithComma() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "199,99", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai pirkti");
        sre.fill();
        String actual = driver.findElement(By.id("priceField")).getAttribute("value");
        Assert.assertEquals(actual, "199,99");
    }

    @Test
    public void negativeRegistrationTestNoPrice() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestPriceZero() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "0", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Neteisinga kaina", actual);
    }

    @Test
    public void negativeRegistrationTestToLowPrice() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "1", "+37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.cssSelector("#newObjectForm > ul > li.field-interval-row.required-form-field > span.error-arrow.hide")).getText();
        System.out.println("Actual Text: " + actual);
        Assert.assertEquals(actual, "Kaina per maža", actual);
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37046123456", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPhoneNumberFormatting1() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "867889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPhoneNumberFormatting2() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "0037067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestPhoneNumberFormatting3() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "37067889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting4() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting5() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting6() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370(678)89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting7() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370-678-89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestWiredPhoneNumberFormatting8() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "8678 89900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestPhoneNumberWithLetterFormatting() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+370A67889900", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestNoPhoneNumber() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestTooShortPhoneNumber() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "678", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[2]"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void negativeRegistrationTestTooLongPhoneNumber() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "6788990012345", generateRndStr(10) + "._-@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[21]/span[2]"))).getText();
        Assert.assertEquals(actual, "Neteisingas telefono numeris");
    }

    @Test
    public void positiveRegistrationTestEmailMinLength() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "A@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestEmailMaxLength64() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(64) + "@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String text = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[22]/span[1]/input")).getAttribute("value");
        System.out.println(text.length());
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestNoEmail() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow")));
        String actual = element.getText();
        Assert.assertEquals(actual, "Nurodykite el. pašto adresą, kad vėliau galėtumėte redaguoti arba pašalinti skelbimą");
    }

    @Test
    public void negativeRegistrationTestEmailNoDot() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@mailcom", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestEmailNoAt() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodasmail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestEmailNoSecondLevelDomain() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestEmailNoCom() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "kodėlAruodas@mail", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestEmailOnlySpecCharacters() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", ",;:{}()[]&!?#%^*=~`|/<>|@mail.", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void negativeRegistrationTestEmailNoUsername() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", "@mail.com", new boolean[]{true, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#newObjectForm > ul > li.required-form-field.has-error > span.error-arrow"))).getText();
        Assert.assertEquals(actual, "Blogas el. pašto adresas");
    }

    @Test
    public void positiveRegistrationTestCheckBoxesTickAgreeToRulesOnly() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, false, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestCheckBoxesTickAgreeToRulesAndFirstTick() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, false, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void positiveRegistrationTestCheckBoxesTickAgreeToRulesAndSecondTick() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{false, true, true}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"btPlanChooseOrder\"]")).getText();
        Assert.assertEquals(actual, "Užsakyti");
    }

    @Test
    public void negativeRegistrationTestCheckBoxesTickFirstAndSecond() {
        SearchRE sre = new SearchRE("Vilnius", "Vilniaus m.", "Antakalnis", "Airių g.", new String[]{"", "", ""}, new String[]{"", "", ""}, "", "", "400", "+37067889900", generateRndStr(10) + "@mail.com", new boolean[]{true, true, false}, "Butai nuomotis");
        sre.fill();
        String actual = driver.findElement(By.xpath("//*[@id=\"newObjectForm\"]/ul/li[25]/span[2]")).getText();
        Assert.assertEquals(actual, "Prašome sutikti su portalo taisyklėmis");
    }


    public void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }


    @BeforeClass
    public void beforeClass() {
        Helper.setUp();
        driver = Helper.driver;
        wait = Helper.wait;

    }

    public static String generateRndStr(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz12345678901234567890";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }

    @BeforeMethod
    public void getWebsite() {
        driver.get("https://www.aruodas.lt/ideti-skelbima/?obj=10");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Quitting WebDriver...");
//        driver.quit();
    }
}
